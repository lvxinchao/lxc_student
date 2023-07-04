package com.system.dao;

import com.system.po.Course;

import java.util.List;

public interface CourseDao {

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
    int addCourse(Course course);

    /**
     * 根据id删除课程号
     * @param id
     * @return
     */
    int deleteCourse(String id);

    /**
     * 修改课程号
     * @param course
     * @return
     */
    int updateCourse(Course course);
}
