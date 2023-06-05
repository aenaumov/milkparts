package ru.milkparts.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component("urlFilter")
public class URLFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info("<<< Filter___RequestURL " + req.getRequestURL());

        if (req.getRequestURI().equals("/login")) {
            HttpSession session = ((HttpServletRequest) request).getSession();
            log.info("<<< Filter___" + "session_id " + session.getId());
        }

        chain.doFilter(request, response);
    }

}
