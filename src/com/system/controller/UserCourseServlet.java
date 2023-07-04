package com.system.controller;

import com.system.po.Grade;
import com.system.po.Student;
import com.system.service.GradeService;
import com.system.service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/userCourse")
public class UserCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");

        if (student == null){
            resp.sendRedirect("/score");
        }else {
            GradeService gradeService = new GradeServiceImpl();
            List<Grade> list = gradeService.selectBySid(student.getId());

            req.setAttribute("list",list);
            req.getRequestDispatcher("userCourse.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
