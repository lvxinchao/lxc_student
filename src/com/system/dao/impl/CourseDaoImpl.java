package com.system.dao.impl;

import com.system.dao.CourseDao;
import com.system.po.Course;
import com.system.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {

    @Override
    public List<Course> selectAll() {
        String sql = "select * from course";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Course result = null;
        List list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                result = new Course();
                result.setcId(rs.getString("c_id"));
                result.setcName(rs.getString("c_name"));
                result.setcTeacher(rs.getString("c_teacher"));
                list.add(result);
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Course selectById(String id) {
        String sql = "select * from course where c_id = ?";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Course result = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                result = new Course();
                result.setcId(rs.getString("c_id"));
                result.setcName(rs.getString("c_name"));
                result.setcTeacher(rs.getString("c_teacher"));
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addCourse(Course course) {
        String sql = "insert into course(c_id,c_name,c_teacher) values(?,?,?)";
        Connection connection = new GetConn().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, course.getcId());
            ps.setString(2, course.getcName());
            ps.setString(3, course.getcTeacher());
            flag = ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteCourse(String id) {
        String sql = "delete from course where c_id = ?";
        Connection connection = new GetConn().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            flag = ps.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int updateCourse(Course course) {
        String sql = "update course  set c_name = ?,c_teacher = ? where c_id = ? ";
        Connection connection = new GetConn().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, course.getcName());
            ps.setString(2, course.getcTeacher());
            ps.setString(3, course.getcId());
            flag = ps.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }
}
