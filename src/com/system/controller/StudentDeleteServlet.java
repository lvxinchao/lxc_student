package com.system.controller;

import com.system.service.StudentService;
import com.system.service.impl.StudentServiceImpl;
import com.system.util.FlagUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentDelete")
public class StudentDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        StudentService studentService = new StudentServiceImpl();
        boolean flag = studentService.deleteById(id);
        if(flag){
            resp.getWriter().write(FlagUtil.getSuccess(null));
        }else {
            resp.getWriter().write(FlagUtil.getFail(null));
        }
    }
}

