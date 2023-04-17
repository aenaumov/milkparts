package ru.milkparts.web.filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class URLInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println(request.getHeader("content-name"));
        System.out.println("_interceptor_" + request.getRequestURL());
//        if (request.getRequestURI().startsWith("/css") ||
//                request.getRequestURI().startsWith("/img") ||
//                request.getRequestURI().startsWith("/js") ||
//                request.getRequestURI().startsWith("/assets")) {
//            return false;
//        }
        return true;
    }
}
