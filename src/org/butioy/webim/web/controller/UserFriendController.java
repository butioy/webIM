
package org.butioy.webim.web.controller;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import org.butioy.framework.resp.RespBean;
import org.butioy.webim.web.domain.UserFriend;
import org.butioy.webim.web.service.IUserFriendService;
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

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
@Controller
@RequestMapping("/userFriend")
public class UserFriendController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(UserFriendController.class);

	@Autowired
	private IUserFriendService userFriendService;
	
	private final String LIST_ACTION = "redirect:/userFriend";
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model, UserFriend query, HttpServletRequest request) {
		Map params = Maps.newHashMap();
		List<UserFriend> list = userFriendService.getList(params);
		model.put("list", list);
		return "/userFriend/index";
	}
	
	/** 进入新增 */
	@RequestMapping(value="/toAdd")
	public String toAdd(ModelMap model,UserFriend userFriend) throws Exception {
		model.put("userFriend",userFriend);
		return "/userFriend/new";
	}
	
	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping("/doAdd")
	@ResponseBody
	public RespBean doAdd(ModelMap model,UserFriend userFriend,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			userFriendService.save(userFriend);
		}catch(ConstraintViolationException e) {
			return result;
		}catch(ValidationException e) {
			return result;
		}
		return result;
	}
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable java.lang.Integer id) throws Exception {
		UserFriend userFriend = userFriendService.getById(id);
		model.put("userFriend",userFriend);
		return "/userFriend/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/{id}/update")
	public String update(ModelMap model,@PathVariable java.lang.Integer id,UserFriend userFriend,BindingResult errors) throws Exception {
		try {
			userFriendService.modify(userFriend);
		}catch(ConstraintViolationException e) {
			return  "/userFriend/edit";
		}catch(ValidationException e) {
			return  "/userFriend/edit";
		}
		return LIST_ACTION;
	}
	
	/** 删除 */
	@RequestMapping(value="/{id}/delete",method=RequestMethod.DELETE)
	public String delete(ModelMap model,@PathVariable java.lang.Integer id) {
		userFriendService.deleteById(id);
		return LIST_ACTION;
	}

	/** 批量删除 */
	@RequestMapping("/batchDelete")
	public String batchDelete(ModelMap model,@RequestParam("items") java.lang.Integer[] items) {
		String ids = "";
		for(int i = 0; i < items.length; i++) {
			ids = items[i]+",";
		}
		userFriendService.deleteByIds(ids);
		return LIST_ACTION;
	}
	
}

