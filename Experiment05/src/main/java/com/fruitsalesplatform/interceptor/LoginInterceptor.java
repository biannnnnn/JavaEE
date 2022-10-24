package com.fruitsalesplatform.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PROJECT_NAME: JavaEE��ҵ
 * @DESCRIPTION:
 * @USER: bian
 * @DATE: 2022/10/18 09:53
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String uri = httpServletRequest.getRequestURI();
        if(!(uri.contains("Login") || uri.contains("login") || uri.contains("register"))) {
            // �ǵ�½����
            if (httpServletRequest.getSession().getAttribute("user") != null) {
                return true;  // ˵���Ѿ���½��������
            } else {
                if(uri.contains("css") || uri.contains("js") || uri.contains("images")) {
                    return true;
                } else {
                    // û�е�½����ת����½����
                    httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/user/toLogin.action");
                }
            }
        } else {
            // ��½����ֱ�ӷ���
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
