package com.system.controller;

import com.system.po.Course;
import com.system.po.Student;
import com.system.service.CourseService;
import com.system.service.impl.CourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/courseShow")
public class CourseShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");

        if (student == null){
            resp.sendRedirect("/score");
        }else {
            String courseKey = req.getParameter("courseKey");

            CourseService courseService = new CourseServiceImpl();
            List<Course> courses = null;

            if (courseKey == null || courseKey == ""){
                courses = courseService.selectAll();
            }else {
                Course course = courseService.selectById(courseKey);
                courses = new ArrayList<Course>();
                courses.add(course);
            }

            //查询全部
            req.setAttribute("courses",courses);
            //去页面
            req.getRequestDispatcher("courseShow.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
