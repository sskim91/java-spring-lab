package com.example.pagehelper.interceptor;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sskim
 */
@Component
public class PagingInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String page = request.getParameter("page");
        if(page == null)
            page = "1";
        PageHelper.startPage(Integer.parseInt(page), 10);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Page<?> datas = (Page<?>) modelAndView.getModel().get("datas");
        String path = request.getContextPath() + request.getServletPath() + "?page";
        new PageNavi
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
