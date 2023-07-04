package com.system.service;

import com.system.po.Course;

import java.util.List;

public interface CourseService {

    /**
     * 查询所有课程
     * @return
     */
    List<Course> selectAll();

    /**
     * 根据课程号查询
     * @param id
     * @return
     */
    Course selectById(String id);

    /**
     * 添加课程
     * @param course
     * @return
     */
    boolean addCourse(Course course);

    /**
     * 根据id删除课程号
     * @param id
     * @return
     */
    boolean deleteCourse(String id);

    /**
     * 修改课程号
     * @param course
     * @return
     */
    boolean updateCourse(Course course);
}
