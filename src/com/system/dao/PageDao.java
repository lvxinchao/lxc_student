package com.system.dao;

import java.util.List;

import com.system.po.Course;
import com.system.po.Student;


public interface PageDao {
	
	 //查询学生
    public List<Student> findAllStu();
	public List<Student> findPageStu(int start, int end);

	//查询课程
	public List<Course> findAllCour();
	public List<Course> findPageCour(int start, int end);
	
}
