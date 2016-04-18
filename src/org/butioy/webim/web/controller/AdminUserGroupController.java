
package org.butioy.webim.web.controller;

import com.google.common.collect.Maps;
import org.butioy.framework.resp.RespBean;
import org.butioy.framework.util.ParamUtils;
import org.butioy.webim.web.domain.UserGroup;
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

import org.butioy.webim.web.service.IUserGroupService;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
@Controller
@RequestMapping("/admin/userGroup")
public class AdminUserGroupController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminUserGroupController.class);

	@Autowired
	private IUserGroupService userGroupService;
	
	private final String LIST_ACTION = "redirect:/admin/userGroup";
	
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model, UserGroup query, HttpServletRequest request) {
		Map params = Maps.newHashMap();
		List<UserGroup> list = userGroupService.getList(params);
		model.put("list", list);
		return "/admin/userGroup/index";
	}

	/** 进入新增 */
	@RequestMapping(value="/toAdd")
	public String toAdd(ModelMap model,UserGroup userGroup) throws Exception {
		model.put("userGroup",userGroup);
		return "/admin/userGroup/new";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping("/doAdd")
	@ResponseBody
	public RespBean doAdd(ModelMap model,UserGroup userGroup,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			userGroupService.save(userGroup);
		}catch(Exception e) {
			result.setFailMessage("系统错误，请稍候重试");
		}
		return result;
	}
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable java.lang.Integer id) throws Exception {
		UserGroup userGroup = userGroupService.getById(id);
		model.put("userGroup",userGroup);
		return "/admin/userGroup/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/{id}/doEdit")
	@ResponseBody
	public RespBean doEdit(ModelMap model,@PathVariable java.lang.Integer id,UserGroup userGroup,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			userGroupService.modify(userGroup);
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
			userGroupService.deleteByIds(ids);
		} catch (Exception e) {
            LOG.info("删除失败，失败原因：" + e.getMessage());
            result.setErrorMessage("系统错误，请稍候重试");
        }
		return result;
	}
	
}

