package com.system.service.impl;

import com.system.dao.GradeDao;
import com.system.dao.impl.GradeDaoImpl;
import com.system.po.Grade;
import com.system.service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService {

    private GradeDao gradeDao = new GradeDaoImpl();

    @Override
    public List<Grade> selectAll() {
        List<Grade> grades = gradeDao.selectAll();
        return grades;
    }

    @Override
    public Grade selectById(String gId) {
        Grade grade = gradeDao.selectById(gId);
        return grade;
    }

    @Override
    public boolean addGrade(Grade grade) {
        int flag = gradeDao.addGrade(grade);
        if(flag == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateGrade(Grade grade) {
        int flag = gradeDao.updateGrade(grade);
        if(flag == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteGrade(int id) {
        int flag = gradeDao.deleteGrade(id);
        if(flag == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<Grade> selectBycId(String cIdKey) {
        List<Grade> list = gradeDao.selectBycId(cIdKey);
        return list;
    }

    @Override
    public List<Grade> selectBySid(String id) {
        List<Grade> list = gradeDao.selectBySid(id);
        return list;
    }
}
