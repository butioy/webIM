
package org.butioy.webim.web.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.butioy.framework.resp.RespBean;
import org.butioy.framework.util.MD5EncryptUtils;
import org.butioy.framework.util.ParamUtils;
import org.butioy.webim.utils.Cons;
import org.butioy.webim.utils.MessageEnum;
import org.butioy.webim.web.domain.MessageLog;
import org.butioy.webim.web.domain.UserFriend;
import org.butioy.webim.web.dto.IMResult;
import org.butioy.webim.web.dto.MessageDto;
import org.butioy.webim.web.dto.UserGroupFriend;
import org.butioy.webim.web.service.IGroupService;
import org.butioy.webim.web.service.IMessageLogService;
import org.butioy.webim.web.service.IUserFriendService;
import org.butioy.webim.web.service.IUserGroupService;
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

import org.butioy.webim.web.domain.User;
import org.butioy.webim.web.service.IUserService;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	@Autowired
	private IUserFriendService userFriendService;

	@Autowired
	private IGroupService groupService;

	@Autowired
	private IUserGroupService userGroupService;

	@Autowired
	private IMessageLogService messageLogService;

	private final String LIST_ACTION = "redirect:/user";
	
	/** 列表 */
	@RequestMapping
	public String index(ModelMap model,User query,HttpServletRequest request) {
		Map params = Maps.newHashMap();
		List<User> list = userService.getList(params);
		model.put("list", list);
		return "/user/index";
	}
	
	/** 进入新增 */
	@RequestMapping(value="/toAdd")
	public String toAdd(ModelMap model,User user) throws Exception {
		model.put("user",user);
		return "/user/new";
	}

	/** 进入新增 */
	@RequestMapping(value="/toRegister")
	public String toRegister() throws Exception {
		return "/user/register";
	}

	/** 保存新增,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping("/doAdd")
	@ResponseBody
	public RespBean doAdd(ModelMap model,User user,BindingResult errors) throws Exception {
		RespBean result = new RespBean();
		try {
			User dbUser = userService.save(user);
            Map<String, String> map = Maps.newHashMap();
            map.put("account", dbUser.getAccount());
			result.setSuccessData(map);
		} catch(ConstraintViolationException e) {
            result.setErrorMessage("系统错误，请稍后重试");
			return result;
		} catch(ValidationException e) {
            result.setErrorMessage("系统错误，请稍后重试");
			return result;
		} catch( Exception e ) {
            result.setErrorMessage("系统错误，请稍后重试");
            return result;
        }
		return result;
	}

	@RequestMapping(value="/toLogin")
	public String toLogin() throws Exception {
		return "/user/login";
	}

	@RequestMapping(value="/doLogin")
	@ResponseBody
	public RespBean doLogin( ModelMap model, User user,  HttpServletRequest request ) throws Exception {
		RespBean result = new RespBean();
		try {
			User dbUser = userService.getByAccount(user.getAccount());
			if( null != dbUser ) {
				String md5Password = MD5EncryptUtils.md5(user.getPassword());
				if( md5Password.equals(dbUser.getPassword()) ) {
					Map userInfo = Maps.newHashMap();
					userInfo.put("id", dbUser.getId());
					userInfo.put("nickName", dbUser.getNickName());
					userInfo.put("realName", dbUser.getRealName());
					userInfo.put("account", dbUser.getAccount());
					userInfo.put("img", dbUser.getImg());
					setSessionAttribute( request, Cons.SESSION_KEY, userInfo, null);
					result.setSuccessMessge("登录成功");
				} else {
					result.setFailMessage("登录失败，帐号或密码错误！");
				}
			} else {
				result.setFailMessage("帐号不存在！");
			}
		} catch(Exception e) {
			result.setErrorMessage("系统异常，请稍候重试");
			return result;
		}
		return result;
	}
	
	/** 编辑 */
	@RequestMapping(value="/{id}/edit")
	public String edit(ModelMap model,@PathVariable java.lang.Integer id) throws Exception {
		User user = userService.getById(id);
		model.put("user",user);
		return "/user/edit";
	}
	
	/** 保存更新,@Valid标注spirng在绑定对象时自动为我们验证对象属性并存放errors在BindingResult  */
	@RequestMapping(value="/{id}/update")
	public String update(ModelMap model,@PathVariable java.lang.Integer id,User user,BindingResult errors) throws Exception {
		try {
			userService.modify(user);
		}catch(ConstraintViolationException e) {
			return  "/user/edit";
		}catch(ValidationException e) {
			return  "/user/edit";
		}
		return LIST_ACTION;
	}
	
	/** 删除 */
	@RequestMapping(value="/{id}/delete",method=RequestMethod.DELETE)
	public String delete(ModelMap model,@PathVariable java.lang.Integer id) {
		userService.deleteById(id);
		return LIST_ACTION;
	}

	/** 批量删除 */
	@RequestMapping("/batchDelete")
	public String batchDelete(ModelMap model,@RequestParam("items") java.lang.Integer[] items) {
		String ids = "";
		for(int i = 0; i < items.length; i++) {
			ids = items[i]+",";
		}
		userService.deleteByIds(ids);
		return LIST_ACTION;
	}

	/**
	 * 用户的好友
	 * @param request
	 * @return
     */
	@RequestMapping("/friend")
	@ResponseBody
	public IMResult friend( HttpServletRequest request ) {
		return searchFriendOrGroup(request, "friend");
	}

	/**
	 * 用户的群组
	 * @param request
	 * @return
     */
	@RequestMapping("/group")
	@ResponseBody
	public IMResult group( HttpServletRequest request ) {
		return searchFriendOrGroup(request, "group");
	}

	/**
	 * 查询用户的好友分组/群组
	 * @param request 当前请求对象
	 * @param type 查询的类型 friend(好友分组)  group(群组)
     * @return
     */
	private IMResult searchFriendOrGroup( HttpServletRequest request, String type ) {
		IMResult result = new IMResult();
		try {
			Object obj = getSessionAttribute(request, Cons.SESSION_KEY);
			if( null != obj ) {
				Map userInfo = (Map) obj;
				String account = (String) userInfo.get("account");
				List<UserGroupFriend> list = Lists.newArrayList();
				if( type.equalsIgnoreCase("friend") ) {
					list = userFriendService.getListByOwner(account);
				} else if( type.equalsIgnoreCase("group") ) {
					list = groupService.getListByOwner(account);
				}
				for( UserGroupFriend gf : list ) {
					gf.setNums(gf.getItem().size());
				}
				result.setSuccess(list);
			} else {
				result.setFailMsg("请先登录");
			}
		} catch (IllegalArgumentException e) {
			result.setFailMsg("参数错误，请重试！");
		}
		return result;
	}

	/**
	 * 群组成员
	 * @param request
	 * @return
     */
	@RequestMapping("/groups")
	@ResponseBody
	public IMResult groups( HttpServletRequest request ) {
		IMResult result = new IMResult();
		try {
			Object obj = getSessionAttribute(request, Cons.SESSION_KEY);
			if( null != obj ) {
				String groupCode = ParamUtils.getParameter(request, "groupCode");
				if( StringUtils.isNotBlank(groupCode) ) {
					List<UserFriend> uses = userGroupService.getListByGroupCode(groupCode);
					result.setSuccess(uses);
				} else {
					result.setFailMsg("参数错误");
				}
			} else {
				result.setFailMsg("请先登录");
			}
		} catch (IllegalArgumentException e) {
			result.setFailMsg("参数错误，请重试！");
		}
		return result;
	}

	/**
	 * 获取未读消息列表
	 * @param request
	 * @return
     */
	@RequestMapping("/getMessages")
	@ResponseBody
	public IMResult getMessages( HttpServletRequest request ) {
		IMResult result = new IMResult();
		String userCode = ParamUtils.getParameter(request, "to");
		String fromUserCode = ParamUtils.getParameter(request, "from");
		String type = ParamUtils.getParameter(request, "type");
		try {
			Integer messageType = MessageEnum.MessageType.valueOf(type.toUpperCase()).getCode();
			List<MessageDto> list = messageLogService.getUserNonConsumeMessageList(fromUserCode, userCode, messageType);
			result.setSuccess(list);
			Date curr = new Date();
			for( MessageDto dto : list ) {
				MessageLog log = new MessageLog();
				log.setId(dto.getId());
				log.setConsumeTime(curr);
				log.setConsumeStatus(MessageEnum.Consume.IS.getCode());
				messageLogService.dynamicModify(log);
			}
		} catch (IllegalArgumentException e) {
			result.setFailMsg("系统错误，请稍后再试！");
		}
		return result;
	}

}

