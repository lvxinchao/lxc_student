package com.system.controller;

import com.system.po.Student;
import com.system.service.StudentService;
import com.system.service.impl.StudentServiceImpl;
import com.system.util.FlagUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/studentAdd")
public class StudentAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");

        if (student == null){
            resp.sendRedirect("/score");
        }else {
            req.getRequestDispatcher("studentAdd.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        String major = req.getParameter("major");
        String college = req.getParameter("college");
        String type = req.getParameter("type");

        Student student = new Student();
        student.setId(username);
        student.setPassword(password);
        student.setsName(name);
        student.setSex(sex);
        student.setMajor(major);
        student.setCollage(college);
        student.setType(type);

        StudentService studentService = new StudentServiceImpl();
        boolean flag = studentService.register(student);
        if (flag){
            resp.getWriter().write(FlagUtil.getSuccess(null));
        }else {
            resp.getWriter().write(FlagUtil.getFail(null));
        }
    }
}
