package com.system.controller;

import com.system.po.Grade;
import com.system.service.GradeService;
import com.system.service.impl.GradeServiceImpl;
import com.system.util.FlagUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/gradeAdd")
public class GradeAddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        String c_id = req.getParameter("c_id");
        String s_id = req.getParameter("s_id");
        String mark = req.getParameter("mark");

        Grade grade = new Grade();
        grade.setsId(s_id);
        grade.setcId(c_id);
        grade.setMark(mark);

        GradeService gradeService = new GradeServiceImpl();
        boolean flag = gradeService.addGrade(grade);

        if(flag){
            resp.getWriter().write(FlagUtil.getSuccess(null));
        }else {
            Map map = new HashMap();
            map.put("message","该同学这么课程已经添加，不可重复添加！");
            resp.getWriter().write(FlagUtil.getFail(map));
        }

    }
}
