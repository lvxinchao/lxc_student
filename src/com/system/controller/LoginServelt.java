package com.system.controller;

import com.system.po.Student;
import com.system.service.StudentService;
import com.system.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServelt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");

        StudentService studentService = new StudentServiceImpl();
        Student student = studentService.login(username, password, type);
        if (student != null){
            HttpSession session = req.getSession();
            session.setAttribute("student",student);

            if (type.equals("管理员")){
                req.getRequestDispatcher("show.jsp").forward(req,resp);
            }else {
                req.getRequestDispatcher("user.jsp").forward(req,resp);
            }
        }else {
            String s = "<script>\n" +
                    "    alert(\"账号或者密码错误！\");\n" +
                    "    document.location.href = \"/web_score/index.jsp\"\n" +
                    "</script>";
            resp.getWriter().write(s);
        }
    }
}
