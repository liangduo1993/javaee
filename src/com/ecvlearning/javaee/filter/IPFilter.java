package com.ecvlearning.javaee.filter;

// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Implements Filter class
public class IPFilter implements Filter  {
    public void  init(FilterConfig config) throws ServletException {

        // Get init parameter
        String testParam = config.getInitParameter("ip");

        //Print the init parameter
        System.out.println("***********************************");
        System.out.println("IP param: " + testParam);
        System.out.println("***********************************");
    }

    public void  doFilter(ServletRequest request, ServletResponse response,
                          FilterChain chain) throws java.io.IOException, ServletException {

        // Get the IP address of client machine.
        String ipAddress = request.getRemoteAddr();

        // Log the IP address and current timestamp.
        System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());

        // Pass request back down the filter chain
        chain.doFilter(request,response);
    }

    public void destroy( ) {
      /* Called before the Filter instance is removed from service by the web container*/
    }
}