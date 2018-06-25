package com.zixun.common.interceptor;

import com.zixun.user.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * create by sintai_zx
 * 2018/6/25 14:22
 */
public class SessionInterceptor implements HandlerInterceptor{

    /**
        @Author sintai_zx
        @Date 2018/6/25 14:24
        @Discreption 拦截所有请求
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
      String uri= request.getRequestURI();
        if (uri.indexOf("login")>=0) {
            return true;
        }
        HttpSession session=request.getSession();
        User user = (User) session.getAttribute("user_info");
        if (user != null) {
            return true;
        }
        //失败转发到登陆页面
        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
