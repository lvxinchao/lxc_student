package com.system.service;

import java.sql.SQLException;
import java.util.List;

import com.system.util.PageBean;

public interface PageService {
	
	 //分页查询学生
	public void findStudent(PageBean pageBean);

	//分页查询课程
	public void findCourse(PageBean courpageBean);
}
