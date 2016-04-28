
package org.butioy.webim.web.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.butioy.framework.base.BaseController;
import org.butioy.framework.resp.RespBean;
import org.butioy.framework.util.MD5EncryptUtils;
import org.butioy.framework.util.ParamUtils;
import org.butioy.webim.utils.Cons;
import org.butioy.webim.utils.MessageEnum;
import org.butioy.webim.web.domain.MessageLog;
import org.butioy.webim.web.domain.User;
import org.butioy.webim.web.domain.UserFriend;
import org.butioy.webim.web.dto.IMResult;
import org.butioy.webim.web.dto.MessageDto;
import org.butioy.webim.web.dto.UserGroupFriend;
import org.butioy.webim.web.service.IGroupService;
import org.butioy.webim.web.service.IMessageLogService;
import org.butioy.webim.web.service.IUserFriendService;
import org.butioy.webim.web.service.IUserGroupService;
import org.butioy.webim.web.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

	@RequestMapping("/toUpload")
	public String toUpload() {
		return "/user/upload";
	}

	@RequestMapping("/doUpload")
	@ResponseBody
	public RespBean doUpload( HttpServletRequest request, @RequestParam("file") MultipartFile file ) {
		RespBean bean = new RespBean();
		if( request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
			Iterator<String> itr = req.getFileNames();
			MultipartFile files = req.getFile("file");
			while ( itr.hasNext() ) {
				System.out.println(itr.next());
			}
		} else {
			bean.setFailMessage("上传图片错误");
		}
		return bean;
	}

}

