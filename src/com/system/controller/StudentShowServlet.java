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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/studentShow")
public class StudentShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");
        if(student == null){
            resp.sendRedirect("/score");
        }else {
            StudentService studentService = new StudentServiceImpl();
            List<Student> students = null;
            String numKey = req.getParameter("num");
            if (numKey != null && numKey != ""){
                Student s = studentService.selectById(numKey);
                students = new ArrayList<Student>();
                students.add(s);
            }else {
                students = studentService.selectAll();
            }

            //全部学生数据
            req.setAttribute("students",students);
            //转发页面
            req.getRequestDispatcher("studentShow.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
