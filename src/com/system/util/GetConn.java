package com.system.util;

import java.sql.*;

public class GetConn {
    // 数据库地址  url   localhost:127.0.0.1  mysql端口：3306
    private String Driver_name = "jdbc:mysql://localhost:3306/stu_web?serverTimezone=Asia/Shanghai&useSSL=false&characterEncoding=utf8";
    // 数据库用户名
    private String USER = "root";
    // 数据库密码
    private String PASS = "0320";
    // 数据库连接
    public Connection con;

    // 构造方法
    public GetConn() {
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接
    public Connection getConnection(){
        if (con == null) {
            try {
                con = DriverManager.getConnection(Driver_name, USER, PASS);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return con;
    }



    // 释放连接
    public void close(ResultSet resultSet, Statement statement, Connection connection) {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 释放连接
    public void close(Statement statement, Connection connection) {

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 释放连接
    public void close(Connection connection) {

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

