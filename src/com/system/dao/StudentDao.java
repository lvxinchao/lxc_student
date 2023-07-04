package com.system.dao;

import com.system.po.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 添加学生
     * @param student
     * @return
     */
    int addStudent(Student student);

    /**
     * 删除学生
     * @param id
     * @return
     */
    int deleteById(String id);

    /**
     * 修改学生
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 查询所有学生
     * @return
     */
    List<Student> selectAll();

    /**
     * 根据学号查询学生
     * @param id
     * @return
     */
    Student selectById(String id);

    /**
     *登录
     * @param username
     * @param password
     * @param type
     * @return
     */
    Student login(String username, String password, String type);
}
