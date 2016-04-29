
package org.butioy.webim.web.controller;

import org.apache.commons.lang3.StringUtils;
import org.butioy.framework.base.BaseController;
import org.butioy.framework.resp.RespBean;
import org.butioy.framework.util.FileUtils;
import org.butioy.framework.util.ParamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(UploadController.class);

	private final String LIST_ACTION = "redirect:/user";

	private static final String UPLOAD_DIR = "/upload/files";

	@RequestMapping("/toUpload")
	public String toUpload() {
		return "/user/upload";
	}

	@RequestMapping("/doUpload")
	@ResponseBody
	public RespBean doUpload( HttpServletRequest request ) {
		RespBean bean = new RespBean();
		if( request instanceof MultipartHttpServletRequest) {
			String webRoot = FileUtils.getWebRootPath();
			String uploadDir = ParamUtils.getParameter(request, "uploadDir");
			if( uploadDir.length() <= 0 ) {
				uploadDir = UPLOAD_DIR;
			}
			String saveDir = webRoot + uploadDir;
			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
			List<MultipartFile> files = req.getFiles("fileList");
			try {
				String[] filePaths = new String[files.size()];
				int index = 0;
				for( MultipartFile file : files ) {
                    String uploadFileName = file.getOriginalFilename();
                    boolean isValid = FileUtils.validFileName(uploadFileName);
                    String fileName = "";
                    String time = System.currentTimeMillis()+"";
                    if( isValid ) {
                        fileName = uploadFileName.substring(0,uploadFileName.lastIndexOf("."))+"_"+time;
                        fileName += fileName+uploadFileName.substring(uploadFileName.lastIndexOf("."));
                    } else {
                        fileName = time+uploadFileName.substring(uploadFileName.lastIndexOf("."));
                    }
                    String filePath = saveDir+"/"+fileName;
                    FileUtils.createFile(filePath);
                    file.transferTo(new File(filePath));
					filePaths[index++] = uploadDir+"/"+fileName;
                }
				bean.setSuccessData(StringUtils.join(filePaths));
			} catch (IOException e) {
				e.printStackTrace();
				bean.setErrorMessage("服务器发生错误");
			}
		} else {
			bean.setFailMessage("上传图片错误");
		}
		return bean;
	}

}

