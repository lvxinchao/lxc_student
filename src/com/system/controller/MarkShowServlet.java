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

@WebServlet("/markShow")
public class MarkShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");

        if(student == null){
            resp.getWriter().write("/score");
        }else {
            String cIdKey = req.getParameter("cIdKey");

            GradeService gradeService = new GradeServiceImpl();
            List<Grade> grades = null;
            if (cIdKey == null || cIdKey == ""){
                grades= gradeService.selectAll();
            }else {
                grades = gradeService.selectBycId(cIdKey);
            }

            req.setAttribute("grades",grades);
            req.getRequestDispatcher("/markShow.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
