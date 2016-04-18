package org.butioy.framework.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 防止XSS攻击的过滤器
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-18 22:04
 */
public class XSSFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(XSSFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter( new XSSHttpServletRequestWrapper((HttpServletRequest)servletRequest), servletResponse );
    }

    @Override
    public void destroy() {}
}
