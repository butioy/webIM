package org.butioy.webim.web.controller;

import org.butioy.framework.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2016-01-30 12:56
 * Since 2015 - 2016
 */
@Controller
@RequestMapping("/chat")
public class ChatController extends BaseController {

    @RequestMapping
    public String index( ModelMap model, HttpServletRequest request ) {
        Object userInfo = getSessionAttribute(request, "USER_INFO");
        if( null == userInfo ) {
            return "redirect:/user/toLogin";
        }
        model.put("userInfo", userInfo);
        return "/chat/index";
    }

}
