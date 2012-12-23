package com.therapservice.mealplanner.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 12:32 PM
 */
@javax.servlet.annotation.WebFilter("/")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    }

    @Override
    public void destroy() {
    }
}
