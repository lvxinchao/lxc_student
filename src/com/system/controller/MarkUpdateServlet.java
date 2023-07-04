package com.system.controller;

import com.system.po.Grade;
import com.system.po.Student;
import com.system.service.GradeService;
import com.system.service.impl.GradeServiceImpl;
import com.system.util.FlagUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/markUpdate")
public class MarkUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Student student = (Student) session.getAttribute("student");

        if (student == null){
            resp.sendRedirect("/score");
        }else {
            String pId = req.getParameter("pid");

            GradeService gradeService = new GradeServiceImpl();
            Grade grade = gradeService.selectById(pId);

            req.setAttribute("grade",grade);
            req.getRequestDispatcher("/markUpdate.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c_id = req.getParameter("c_id");
        String s_id = req.getParameter("s_id");
        String mark = req.getParameter("mark");

        Grade grade = new Grade();
        grade.setcId(c_id);
        grade.setsId(s_id);
        grade.setMark(mark);

        GradeService gradeService = new GradeServiceImpl();
        boolean flag = gradeService.updateGrade(grade);

        if (flag){
            resp.getWriter().write(FlagUtil.getSuccess(null));
        }else {
            resp.getWriter().write(FlagUtil.getFail(null));
        }
    }
}
