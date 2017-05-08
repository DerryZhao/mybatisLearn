package com.zhq.dao;

import java.util.List;

import com.zhq.pojo.Activity;

public interface ActivityDao {
	
	List<Activity> selectByAll();
	Activity selectById(int id);
}
