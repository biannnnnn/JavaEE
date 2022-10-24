package com.fruitsalesplatform.controller;

import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PROJECT_NAME: JavaEE×÷Òµ
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 11:28
 */
@Controller
public class UserController extends BaseController {
    @Resource
    UserService userService;

    // Ìø×ªÖÁµÇÂ½Ò³Ãæ
    @RequestMapping("/user/toLogin")
    public String toLogin() {
        return "login";  // ×ªÏòµÇÂ½Ò³Ãæ
    }

    @RequestMapping("/user/login")
    public String login(User user, Model model, HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        map.put("username", user.getUserName());
        map.put("password", user.getPassword());
        List<User> userList = userService.find(map);
        if(userList != null && userList.size() > 0) {
            request.getSession().setAttribute("user", userList.get(0));
            return "/home";
        }
        model.addAttribute("errorMsg", "µÇÂ½Ê§°Ü£¡ÕËºÅ»òÃÜÂë´íÎó£¡");
        System.out.println("wada");
        return "/login";
    }
}