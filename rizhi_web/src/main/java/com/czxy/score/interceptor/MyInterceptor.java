package com.czxy.score.interceptor;

import com.czxy.score.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取方法名
        String url = request.getRequestURI();
        //2.碰到这些直接放行
        if (url.contains("css") || url.contains("fonts") || url.contains("images") || url.contains("js") || url.contains("login")) {
            return true;
        }

        if (!url.contains("index.html")){
            //3.从session域种获取user
            User user = (User) request.getSession().getAttribute("user");
            //4.如果为空拦截  不为空放行
            if (user == null) {
                response.sendRedirect("index.html");
                return false;
            }else {
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
