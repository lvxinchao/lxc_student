package com.system.service;

import com.system.po.Student;

import java.util.List;

public interface StudentService {

    boolean register(Student student);

    Student login(String username,String password,String type);

    /**
     * 添加学生
     * @param student
     * @return
     */
    boolean addStudent(Student student);

    /**
     * 删除学生
     * @param id
     * @return
     */
    boolean deleteById(String id);

    /**
     * 修改学生
     * @param student
     * @return
     */
    boolean updateStudent(Student student);

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
}
