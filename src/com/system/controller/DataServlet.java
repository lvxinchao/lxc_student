package com.system.controller;

import com.system.po.Course;
import com.system.po.Student;
import com.system.service.CourseService;
import com.system.service.StudentService;
import com.system.service.impl.CourseServiceImpl;
import com.system.service.impl.StudentServiceImpl;
import com.system.util.FlagUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/data")
public class DataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");

        if (student == null){
            resp.sendRedirect("/score");
        }else {
            String s_id = req.getParameter("s_id");
            StudentService studentService = new StudentServiceImpl();
            Student student1 = studentService.selectById(s_id);

            if (student1 != null){
                Map map = new HashMap();
                map.put("student",student1);
                resp.getWriter().write(FlagUtil.getSuccess(map));
            }else {
                resp.getWriter().write(FlagUtil.getFail(null));
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String c_id = req.getParameter("c_id");

        CourseService courseService = new CourseServiceImpl();
        Course course = courseService.selectById(c_id);

        if (course != null){
            Map map = new HashMap();
            map.put("course",course);
            resp.getWriter().write(FlagUtil.getSuccess(map));
        }else {
            resp.getWriter().write(FlagUtil.getFail(null));
        }
    }
}
