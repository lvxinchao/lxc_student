package com.system.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.system.po.Course;
import com.system.po.Student;
import com.system.service.PageService;
import com.system.service.impl.PageServiceImpl;
import com.system.util.PageBean;

/**
 * Servlet implementation class FindAllUserServlet
 */
@WebServlet("/findCour_PageServlet")
public class FindCour_PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FindCour_PageServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 1接收参数
		int index = 1; // 当前面
		String sindex = request.getParameter("index");
		if (sindex != null && !"".equals(sindex)) {
			index = Integer.parseInt(sindex);
		}
		
		int size = 5;// 每页显示的记录数
		String ssize = request.getParameter("size");
		if (ssize != null && !"".equals(ssize)) {
			size = Integer.parseInt(ssize);
		}

		PageBean<Course> courpageBean = new PageBean<Course>();
		courpageBean.setIndex(index);
		courpageBean.setSize(size);

		// 2调用业务层
		PageService pageService = new PageServiceImpl();
		pageService.findCourse(courpageBean);
	
		// 3跳转
		request.setAttribute("courpageBean", courpageBean);
		request.getRequestDispatcher("courseShow.jsp").forward(request,response);
	}

}
