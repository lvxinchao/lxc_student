package com.system.service.impl;

import com.system.dao.PageDao;
import com.system.dao.impl.PageDaoImpl;
import com.system.po.Course;
import com.system.po.Student;
import com.system.service.PageService;
import com.system.util.PageBean;

import java.util.List;



public class PageServiceImpl implements PageService {
   
	@Override
	public void findStudent(PageBean pageBean) {
		PageDao userDao=new PageDaoImpl();
		//1.获取总的记录数
		//查询全部数据，统计count(*)
		int totalCount=userDao.findAllStu().size();
		System.out.println(totalCount);
	    //2.通过总记录数给PageBean的其它属性赋值
		pageBean.setTotalCount(totalCount);//其它都有了，只差list数据了
		//总页数，number[]   3个参数得到，2个控制层已经知道，差1个list
		//dao查询出来1-5   45-82  mysql
		//3.获取当前页的用户数据，并赋给PageBean
		/**
		 * size=5
		 * 页号                           起始记录数                       结束记录数
		 * 1                1                5
		 * 2                6                10
		 * 3               11                15
		 * ......          ......           ......
		 * index    >=(index-1)*size+1    <=index*size
		 * 起始数用大于表示，+1就可以去掉了，如下：
		 * index     >(index-1)*size      <=index*size
		 * 
		 */
		int start=pageBean.getStartRow();
		int end=pageBean.getEndRow();
		List<Student> userList=userDao.findPageStu(start,end);
//		List<Student> userList=userDao.findAll();
		pageBean.setList(userList); // 6个参数全部搞定
	}

	public void findCourse(PageBean courpageBean) {
		PageDao userDao=new PageDaoImpl();

		int totalCount=userDao.findAllCour().size();
		System.out.println(totalCount);

		courpageBean.setTotalCount(totalCount);//其它都有了，只差list数据了

		int start=courpageBean.getStartRow();
		int end=courpageBean.getEndRow();
		List<Course> courList=userDao.findPageCour(start,end);
		courpageBean.setList(courList);
	}


}
