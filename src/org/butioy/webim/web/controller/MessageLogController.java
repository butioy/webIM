
package org.butioy.webim.web.controller;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import org.butioy.framework.resp.RespBean;
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

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import org.butioy.framework.base.BaseController;

import org.butioy.webim.web.domain.MessageLog;
import org.butioy.webim.web.service.IMessageLogService;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-31 16:57
 * Since 2015 - 2016
 */
@Controller
@RequestMapping("/messageLog")
public class MessageLogController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(MessageLogController.class);

	@Autowired
	private IMessageLogService messageLogService;
	
	private final String LIST_ACTION = "redirect:/messageLog";
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,MessageLog query,HttpServletRequest request) {
		Map params = Maps.newHashMap();
		List<MessageLog> list = messageLogService.getList(params);
		model.put("list", list);
		return "/messageLog/index";
	}
	
	/** 进入新增 */
	@RequestMapping(value="/toAdd")
	public String toAdd(ModelMap model,MessageLog messageLog) throws Exception {
		model.put("messageLog",messageLog);
		return "/messageLog/new";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping("/doAdd")
	@ResponseBody
	public RespBean doAdd(ModelMap model,MessageLog messageLog,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			messageLogService.save(messageLog);
		}catch(ConstraintViolationException e) {
			return result;
		}catch(ValidationException e) {
			return result;
		}
		return result;
	}
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable java.lang.Long id) throws Exception {
		MessageLog messageLog = messageLogService.getById(id);
		model.put("messageLog",messageLog);
		return "/messageLog/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/{id}/update")
	public String update(ModelMap model,@PathVariable java.lang.Long id,MessageLog messageLog,BindingResult errors) throws Exception {
		try {
			messageLogService.modify(messageLog);
		}catch(ConstraintViolationException e) {
			return  "/messageLog/edit";
		}catch(ValidationException e) {
			return  "/messageLog/edit";
		}
		return LIST_ACTION;
	}
	
	/** 删除 */
	@RequestMapping(value="/{id}/delete",method=RequestMethod.DELETE)
	public String delete(ModelMap model,@PathVariable java.lang.Long id) {
		messageLogService.deleteById(id);
		return LIST_ACTION;
	}

	/** 批量删除 */
	@RequestMapping("/batchDelete")
	public String batchDelete(ModelMap model,@RequestParam("items") java.lang.Long[] items) {
		String ids = "";
		for(int i = 0; i < items.length; i++) {
			ids = items[i]+",";
		}
		messageLogService.deleteByIds(ids);
		return LIST_ACTION;
	}
	
}

