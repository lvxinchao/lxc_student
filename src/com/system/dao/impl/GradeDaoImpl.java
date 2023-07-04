package com.system.dao.impl;

import com.system.dao.GradeDao;
import com.system.po.Course;
import com.system.po.Grade;
import com.system.po.Student;
import com.system.util.GetConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl implements GradeDao {

    @Override
    public List<Grade> selectAll() {
        String sql = "select * from grade";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Grade result = null;
        List<Grade> list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                result = new Grade();
                result.setId(rs.getInt("g_id"));
                result.setMark(rs.getString("mark"));
                Course course = new CourseDaoImpl().selectById(rs.getString("c_id"));
                Student student = new StudentDaoImpl().selectById(rs.getString("s_id"));
                result.setStudent(student);
                result.setCourse(course);
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
    public Grade selectById(String gId) {
        String sql = "select * from grade where g_id = ?";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Grade result = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,new Integer(gId));
            rs = ps.executeQuery();
            while(rs.next()){
                result = new Grade();
                result.setId(rs.getInt("g_id"));
                result.setMark(rs.getString("mark"));
                Course course = new CourseDaoImpl().selectById(rs.getString("c_id"));
                Student student = new StudentDaoImpl().selectById(rs.getString("s_id"));
                result.setStudent(student);
                result.setCourse(course);
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int addGrade(Grade grade) {
        String sql = "insert into grade(c_id,s_id,mark) values(?,?,?)";
        String sql_cId_sId = "select * from grade where c_id = ? and s_id = ?";
        Connection connection = new GetConn().getConnection();
        //返回值
        int flag = 0;
        try {
            connection.setAutoCommit(false);
            PreparedStatement ps_cId_sId = connection.prepareStatement(sql_cId_sId);
            ps_cId_sId.setString(1, grade.getcId());
            ps_cId_sId.setString(2, grade.getsId());
            ResultSet resultSet = ps_cId_sId.executeQuery();

            if (resultSet.next()){
                flag = 0;
            }else {
                PreparedStatement ps = connection.prepareStatement(sql);
                ps.setString(1, grade.getcId());
                ps.setString(2, grade.getsId());
                ps.setString(3, grade.getMark());
                flag = ps.executeUpdate();
            }
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;

    }

    @Override
    public int updateGrade(Grade grade) {
        String sql = "update grade  set mark = ? where c_id = ? and s_id = ? ";
        Connection connection = new GetConn().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, grade.getMark());
            ps.setString(2, grade.getcId());
            ps.setString(3, grade.getsId());
            flag = ps.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public int deleteGrade(int id) {
        String sql = "delete from grade where g_id = ?";
        Connection connection = new GetConn().getConnection();
        //返回值
        int flag = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            flag = ps.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<Grade> selectBycId(String cIdKey) {
        String sql = "select * from grade where c_id = ?";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Grade result = null;
        List<Grade> list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,cIdKey);
            rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                result = new Grade();
                result.setId(rs.getInt("g_id"));
                result.setMark(rs.getString("mark"));
                Course course = new CourseDaoImpl().selectById(rs.getString("c_id"));
                Student student = new StudentDaoImpl().selectById(rs.getString("s_id"));
                result.setStudent(student);
                result.setCourse(course);
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
    public List<Grade> selectBySid(String id) {
        String sql = "select * from grade where s_id = ?";
        Connection connection = new GetConn().getConnection();
        ResultSet rs = null;
        Grade result = null;
        List<Grade> list = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,id);
            rs = ps.executeQuery();
            list = new ArrayList();
            while(rs.next()){
                result = new Grade();
                result.setId(rs.getInt("g_id"));
                result.setMark(rs.getString("mark"));
                Course course = new CourseDaoImpl().selectById(rs.getString("c_id"));
                Student student = new StudentDaoImpl().selectById(rs.getString("s_id"));
                result.setStudent(student);
                result.setCourse(course);
                list.add(result);
            }
            connection.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
}
