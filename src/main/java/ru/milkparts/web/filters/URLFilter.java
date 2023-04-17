package ru.milkparts.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("urlFilter")
public class URLFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        System.out.println(req.getRequestURL());
//        if (req.getRequestURI().startsWith("/css") ||
//                req.getRequestURI().startsWith("/img") ||
//                req.getRequestURI().startsWith("/js") ||
//                req.getRequestURI().startsWith("/assets")) {
//            return;
//        }
        chain.doFilter(request, response);
    }

}
