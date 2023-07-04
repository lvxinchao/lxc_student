package com.system.controller;

import com.system.service.GradeService;
import com.system.service.impl.GradeServiceImpl;
import com.system.util.FlagUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/markDelete")
public class MarkDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gId = req.getParameter("gId");

        GradeService gradeService = new GradeServiceImpl();
        boolean flag = gradeService.deleteGrade(new Integer(gId));

        if (flag){
            resp.getWriter().write(FlagUtil.getSuccess(null));
        }else {
            resp.getWriter().write(FlagUtil.getFail(null));
        }

    }
}
