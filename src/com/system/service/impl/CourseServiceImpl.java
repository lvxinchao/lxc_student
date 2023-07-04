package com.system.service.impl;

import com.system.dao.CourseDao;
import com.system.dao.impl.CourseDaoImpl;
import com.system.po.Course;
import com.system.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public List<Course> selectAll() {
        List<Course> courses = courseDao.selectAll();
        return courses;
    }

    @Override
    public Course selectById(String id) {
        Course course = courseDao.selectById(id);
        return course;
    }

    @Override
    public boolean addCourse(Course course) {
        int flag = courseDao.addCourse(course);
        if(flag == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCourse(String id) {
        int flag = courseDao.deleteCourse(id);
        if(flag == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateCourse(Course course) {
        int flag = courseDao.updateCourse(course);
        if(flag == 1){
            return true;
        }
        return false;
    }
}
