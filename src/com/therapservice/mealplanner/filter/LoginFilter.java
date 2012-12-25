package com.therapservice.mealplanner.filter;

import com.therapservice.mealplanner.web.auth.AuthKey;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Bazlur Rahman Rokon
 * Date: 12/23/12
 * Time: 12:32 PM
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession(false);

        String requestedUri = ((HttpServletRequest) servletRequest).getRequestURI();

        if ((session == null || session.getAttribute(AuthKey.AUTH_KEY) == null) && (requestedUri.contains("meal") || requestedUri.contains("logout"))) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login");
        } else if (session != null && session.getAttribute(AuthKey.AUTH_KEY) != null && (requestedUri.contains("login") || requestedUri.contains("signup"))) {
            ((HttpServletResponse) servletResponse).sendRedirect("home/index");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
