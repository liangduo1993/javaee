package com.ecvlearning.javaee.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class Authentication implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String path = ((HttpServletRequest) servletRequest).getRequestURI();
        if (path.indexOf("/login")!=-1) {
            filterChain.doFilter(servletRequest, servletResponse); // Just continue chain.
        }


        Object loggedObj =  ((HttpServletRequest)servletRequest).getSession().getAttribute("logged");
        boolean logged = false;
        if(null != loggedObj){
            logged = (boolean)loggedObj;
        }

        if(logged){
            // Pass request back down the filter chain
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            servletRequest.setAttribute("info","Please login.");
            RequestDispatcher dispatcher = ((HttpServletRequest)servletRequest).getSession().getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
