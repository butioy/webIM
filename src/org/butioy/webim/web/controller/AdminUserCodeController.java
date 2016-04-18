
package org.butioy.webim.web.controller;

import com.google.common.collect.Maps;
import org.butioy.framework.resp.RespBean;
import org.butioy.framework.util.ParamUtils;
import org.butioy.webim.web.domain.UserCode;
import org.butioy.webim.web.service.IUserCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import org.butioy.framework.base.BaseController;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-02-13 12:06
 * Since 2015 - 2016
 */
@Controller
@RequestMapping("/admin/userCode")
public class AdminUserCodeController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminUserCodeController.class);

	@Autowired
	private IUserCodeService userCodeService;
	
	private final String LIST_ACTION = "redirect:/admin/userCode";
	
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,UserCode query,HttpServletRequest request) {
//		Map params = Maps.newHashMap();
//		List<UserCode> list = userCodeService.getList(params);
//		model.put("list", list);
		return "/admin/userCode/index";
	}

	/** 进入新增 */
	@RequestMapping(value="/toAdd")
	public String toAdd(ModelMap model,UserCode userCode) throws Exception {
		model.put("userCode",userCode);
		return "/admin/userCode/new";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping("/doAdd")
	@ResponseBody
	public RespBean doAdd(ModelMap model,UserCode userCode,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			userCodeService.save(userCode);
			result.setSuccessMessge("操作成功");
		}catch(Exception e) {
			result.setFailMessage("系统错误，请稍候重试");
		}
		return result;
	}
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable Integer id) throws Exception {
		UserCode userCode = userCodeService.getById(id);
		model.put("userCode",userCode);
		return "/admin/userCode/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/{id}/doEdit")
	@ResponseBody
	public RespBean doEdit(ModelMap model,@PathVariable Integer id,UserCode userCode,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			userCodeService.modify(userCode);
			result.setSuccessMessge("操作成功");
		} catch (Exception e) {
            LOG.info("更新失败，失败原因：" + e.getMessage());
            result.setErrorMessage("系统错误，请稍候重试");
        }
		return result;
	}

	/** 批量删除 */
	@RequestMapping("/batchDelete")
	@ResponseBody
	public RespBean batchDelete( HttpServletRequest request ) {
		RespBean result = new RespBean();
		try {
			String ids = ParamUtils.getParameter(request, "ids", "");
			userCodeService.deleteByIds(ids);
			result.setSuccessMessge("操作成功");
		} catch (Exception e) {
            LOG.info("删除失败，失败原因：" + e.getMessage());
            result.setErrorMessage("系统错误，请稍候重试");
        }
		return result;
	}

	/** 生成用户CODE码 */
	@RequestMapping("/generateCode")
	@ResponseBody
	public RespBean generateCode( HttpServletRequest request ) {
		RespBean result = new RespBean();
		try {
			Integer total = ParamUtils.getIntParameter(request, "total", 0);
			userCodeService.generateUserAccount( total );
			result.setSuccessMessge("生成CODE码成功");
		} catch (Exception e) {
			LOG.info("生成用户CODE码失败，失败原因：" + e.getMessage());
			result.setErrorMessage("系统错误，请稍候重试");
		}
		return result;
	}
	
}

