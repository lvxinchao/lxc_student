package com.system.service;

import com.system.po.Grade;

import java.util.List;

public interface GradeService {

    /**
     * 查询所有成绩
     * @return
     */
    List<Grade> selectAll();

    /**
     *  根据课程号查询所有成绩
     * @return
     */
    Grade selectById(String gId);

    /**
     * 添加成绩
     * @param grade
     * @return
     */
    boolean addGrade(Grade grade);

    /**
     * 修改成绩
     * @param grade
     * @return
     */
    boolean updateGrade(Grade grade);

    /**
     * 删除成绩
     * @param id
     * @return
     */
    boolean deleteGrade(int id);

    /**
     * 查询
     * @param cIdKey
     * @return
     */
    List<Grade> selectBycId(String cIdKey);

    /**
     * 根据学生ID查询所有课程
     * @param id
     * @return
     */
    List<Grade> selectBySid(String id);
}
