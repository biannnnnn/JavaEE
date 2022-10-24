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
 * @PROJECT_NAME: JavaEE��ҵ
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 11:28
 */
@Controller
public class UserController extends BaseController {
    @Resource
    UserService userService;

    // ��ת����½ҳ��
    @RequestMapping("/user/toLogin")
    public String toLogin() {
        return "login";  // ת���½ҳ��
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
        model.addAttribute("errorMsg", "��½ʧ�ܣ��˺Ż��������");
        System.out.println("wada");
        return "/login";
    }
}