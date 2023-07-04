package com.system.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.dao.PageDao;
import com.system.po.Course;
import com.system.po.Student;
import com.system.util.*;

public class PageDaoImpl implements PageDao {
	@Override
	public List<Student> findAllStu() {
		List<Student> stu=new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student=null;
		// 加载驱动
		// 获取连接
		try {
			conn = new GetConn().getConnection();
			// 建立命令发送器（prepareStatement）
			String sql = "select * from `student` ";
			ps = conn.prepareStatement(sql);
			// 发送命令并得到结果
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String id = rs.getString("id");
				System.out.println(id);
				String sName = rs.getString("s_name");
				String sex = rs.getString("sex");
				String major = rs.getString("major");
				String collage = rs.getString("college");
				// 封装到对象中
				student = new Student(id,sName,sex,major,collage);
				stu.add(student);
			}
		} catch (SQLException e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}

		}
		return stu;
	}
	@Override
	public List<Student> findPageStu(int start, int end) {
		List<Student> stu = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		// 加载驱动
		// 获取连接
		try {
			conn = new GetConn().getConnection();
			// 建立命令发送器（prepareStatement）
			String sql= "select * from `stu_web`.`student` order by `id` limit "+start+","+(end-start)+" ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String id = rs.getString("id");
				System.out.println(id);
				String sName = rs.getString("s_name");
				String sex = rs.getString("sex");
				String major = rs.getString("major");
				String collage = rs.getString("college");
				// 封装到对象中
				student = new Student(id,sName,sex,major,collage);
				stu.add(student);
			}
		} catch (SQLException e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
          
		}
		return stu;
	}

	public List<Course> findAllCour() {
		List<Course> cour=new ArrayList<Course>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course course=null;
		// 加载驱动
		// 获取连接
		try {
			conn = new GetConn().getConnection();
			// 建立命令发送器（prepareStatement）
			String sql = "select * from `course` ";
			ps = conn.prepareStatement(sql);
			// 发送命令并得到结果
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String id = rs.getString("c_id");
				System.out.println(id);
				String Name = rs.getString("c_name");
				String teacher = rs.getString("c_teacher");
				// 封装到对象中
				course = new Course(id,Name,teacher);
				cour.add(course);
			}
		} catch (SQLException e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}

		}
		return cour;
	}
	@Override
	public List<Course> findPageCour(int start, int end) {
		List<Course> cour=new ArrayList<Course>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course course=null;
		// 加载驱动
		// 获取连接
		try {
			conn = new GetConn().getConnection();
			// 建立命令发送器（prepareStatement）
			String sql= "select * from `stu_web`.`course` order by `c_id` limit "+start+","+(end-start)+" ";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 处理结果
			while (rs.next()) {
				// 获取各个字段的值
				String id = rs.getString("c_id");
				System.out.println(id);
				String Name = rs.getString("c_name");
				String teacher = rs.getString("c_teacher");
				// 封装到对象中
				course = new Course(id,Name,teacher);
				cour.add(course);
			}
		} catch (SQLException e) {

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

				}
			}

		}
		return cour;
	}
}



