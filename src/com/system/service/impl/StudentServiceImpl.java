package com.system.service.impl;

import com.system.dao.StudentDao;
import com.system.dao.impl.StudentDaoImpl;
import com.system.po.Student;
import com.system.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public boolean register(Student student) {
        int i = studentDao.addStudent(student);
        if(i == 1){
            return true;
        }
        return false;
    }

    @Override
    public Student login(String username, String password, String type) {
        return studentDao.login(username,password,type);
    }

    @Override
    public boolean addStudent(Student student) {
        int flag = studentDao.addStudent(student);
        if(flag == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        int flag = studentDao.deleteById(id);
        if(flag == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        int flag = studentDao.updateStudent(student);
        if(flag == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<Student> selectAll() {
        List<Student> students = studentDao.selectAll();
        return students;
    }

    @Override
    public Student selectById(String id) {
        Student student = studentDao.selectById(id);
        return student;
    }
}
