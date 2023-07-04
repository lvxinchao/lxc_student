package com.system.controller;

import com.system.po.Course;
import com.system.po.Student;
import com.system.service.CourseService;
import com.system.service.impl.CourseServiceImpl;
import com.system.util.FlagUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/courseUpdate")
public class CourseUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");

        if(student == null){
            resp.sendRedirect("/score");
        }else {
            String id = req.getParameter("id");
            CourseService courseService = new CourseServiceImpl();
            Course course = courseService.selectById(id);

            //数据回显
            req.setAttribute("course",course);
            req.getRequestDispatcher("/courseUpdate.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cId = req.getParameter("cId");
        String cName = req.getParameter("cName");
        String cTeacher = req.getParameter("cTeacher");

        Course course = new Course();
        course.setcId(cId);
        course.setcName(cName);
        course.setcTeacher(cTeacher);

        CourseService courseService = new CourseServiceImpl();
        boolean flag = courseService.updateCourse(course);

        if(flag){
            resp.getWriter().write(FlagUtil.getSuccess(null));
        }else {
            resp.getWriter().write(FlagUtil.getFail(null));
        }
    }
}
