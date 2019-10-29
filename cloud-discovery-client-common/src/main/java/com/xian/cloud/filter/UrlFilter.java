package com.xian.cloud.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

/**
 * <Description>
 *
 * @author xianliru@100tal.com
 * @version 1.0
 * @createDate 2019/10/29 13:57
 */
@WebFilter(filterName = "test",urlPatterns = "/*")
@Slf4j
public class UrlFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.warn("UrlFilter init.......");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String requestURI = req.getRequestURI();
        String header = req.getHeader("X-Foo");
        String abc = req.getHeader("X-ABC");

        log.warn("过滤器：请求地址"+requestURI);
        log.warn("uuid:{}",header);
        log.warn("abc uuid:{}",abc);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.warn(" 过滤器被销毁");

    }
}