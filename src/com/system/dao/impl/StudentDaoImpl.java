package com.system.dao.impl;

import com.system.dao.StudentDao;
import com.system.po.Student;
import com.system.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public int addStudent(Student student) {
        String sql = "insert into student(id,s_name,password,sex,major,college,type) values(?,?,?,?,?,?,?)";
        Connection connection = new GetConn().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,student.getId());
            ps.setString(2,student.getsName());
            ps.setString(3,student.getPassword());
            ps.setString(4,student.getSex());
            ps.setString(5,student.getMajor());
            ps.setString(6,student.getCollage());
            ps.setString(7,student.getType());
            flag = ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteById(String id) {
        String sql = "delete from student where id = ?";
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
    public int updateStudent(Student student) {
        String sql = "update student  set s_name = ?,sex = ?,major = ?,college = ?,type = ? where id = ? ";
        Connection connection = new GetConn().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, student.getsName());
            ps.setString(2, student.getSex());
            ps.setString(3, student.getMajor());
            ps.setString(4, student.getCollage());
            ps.setString(5, student.getType());
            ps.setString(6, student.getId());
            flag = ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Student> selectAll() {
        String sql = "select * from student where type = '学生'";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Student result = null;
        List list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                result = new Student();
                result.setId(rs.getString("id"));
                result.setsName(rs.getString("s_name"));
                result.setSex(rs.getString("sex"));
                result.setMajor(rs.getString("major"));
                result.setCollage(rs.getString("college"));
                result.setType(rs.getString("type"));
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
    public Student selectById(String id) {
        String sql = "select * from student where id = ?";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Student result = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            while(rs.next()){
                result = new Student();
                result.setId(rs.getString("id"));
                result.setsName(rs.getString("s_name"));
                result.setPassword(rs.getString("password"));
                result.setSex(rs.getString("sex"));
                result.setMajor(rs.getString("major"));
                result.setCollage(rs.getString("college"));
                result.setType(rs.getString("type"));
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Student login(String username, String password, String type) {
        String sql = "select * from student where id = ? and password = ? and type = ?";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Student result = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,type);
            rs = ps.executeQuery();
            while(rs.next()){
                result = new Student();
                result.setId(rs.getString("id"));
                result.setsName(rs.getString("s_name"));
                result.setSex(rs.getString("sex"));
                result.setMajor(rs.getString("major"));
                result.setCollage(rs.getString("college"));
                result.setType(rs.getString("type"));
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
