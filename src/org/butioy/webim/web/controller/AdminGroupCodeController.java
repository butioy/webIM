
package org.butioy.webim.web.controller;

import com.google.common.collect.Maps;
import org.butioy.framework.resp.RespBean;
import org.butioy.framework.util.ParamUtils;
import org.butioy.webim.web.domain.GroupCode;
import org.butioy.webim.web.service.IGroupCodeService;
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
@RequestMapping("/admin/groupCode")
public class AdminGroupCodeController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminGroupCodeController.class);

	@Autowired
	private IGroupCodeService groupCodeService;
	
	private final String LIST_ACTION = "redirect:/admin/groupCode";
	
	/**
	 * 增加了@ModelAttribute的方法可以在本controller方法调用前执行,可以存放一些共享变量,如枚举值,或是一些初始化操作
	 */
	@ModelAttribute
	public void init(ModelMap model) {
		model.put("now", new java.sql.Timestamp(System.currentTimeMillis()));
	}
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,GroupCode query,HttpServletRequest request) {
		Map params = Maps.newHashMap();
		List<GroupCode> list = groupCodeService.getList(params);
		model.put("list", list);
		return "/admin/groupCode/index";
	}

	/** 进入新增 */
	@RequestMapping(value="/toAdd")
	public String toAdd(ModelMap model,GroupCode groupCode) throws Exception {
		model.put("groupCode",groupCode);
		return "/admin/groupCode/new";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping("/doAdd")
	@ResponseBody
	public RespBean doAdd(ModelMap model,GroupCode groupCode,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			groupCodeService.save(groupCode);
		}catch(Exception e) {
			result.setFailMessage("系统错误，请稍候重试");
		}
		return result;
	}
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable Integer id) throws Exception {
		GroupCode groupCode = groupCodeService.getById(id);
		model.put("groupCode",groupCode);
		return "/admin/groupCode/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/{id}/doEdit")
	@ResponseBody
	public RespBean doEdit(ModelMap model,@PathVariable Integer id,GroupCode groupCode,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			groupCodeService.modify(groupCode);
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
			groupCodeService.deleteByIds(ids);
		} catch (Exception e) {
            LOG.info("删除失败，失败原因：" + e.getMessage());
            result.setErrorMessage("系统错误，请稍候重试");
        }
		return result;
	}
	
}

