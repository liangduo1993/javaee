package com.ecvlearning.javaee.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Authentication extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = (String)request.getParameter("userName");
        String passWord = (String)request.getParameter("password");

        String nextJSP = "/loginResult.jsp";
        if(userName.equals(passWord)){
            request.setAttribute("result","Login succeeded!");
            request.getSession().setAttribute("logged", true);
        }else{
            request.setAttribute("result","Login failed!");
            request.getSession().setAttribute("logged", false);
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //do nothing
    }
}
