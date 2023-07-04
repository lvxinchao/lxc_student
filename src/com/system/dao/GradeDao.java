package com.system.dao;

import com.system.po.Grade;

import java.util.List;

public interface GradeDao {

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
    int addGrade(Grade grade);

    /**
     * 修改成绩
     * @param grade
     * @return
     */
    int updateGrade(Grade grade);

    /**
     * 删除成绩
     * @param id
     * @return
     */
    int deleteGrade(int id);

    List<Grade> selectBycId(String cIdKey);

    List<Grade> selectBySid(String id);
}
