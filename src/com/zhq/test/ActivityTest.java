package com.zhq.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zhq.dao.ActivityDao;
import com.zhq.pojo.Activity;

public class ActivityTest {
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	
	@Before
	public void setUp() throws Exception {
		try {
			reader = Resources.getResourceAsReader("mybatis_config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void select() {
		SqlSession session = sqlSessionFactory.openSession();
//		Activity activity = session.selectOne("com.zhq.dao.ActivityDao.selectById",10);
		ActivityDao activityDao = session.getMapper(ActivityDao.class);
	    Activity activity = activityDao.selectById(10);
		session.commit();
		System.out.println(activity);
		Assert.assertNotEquals("查找成功", "爱美丽", activity.getTitle());
		session.close();
	}
	
	@Test
	public void insert(){
		SqlSession session = sqlSessionFactory.openSession();
		ActivityDao activityDao = session.getMapper(ActivityDao.class);
	    Activity activity = new Activity();
	    activity.setTitle("耐克大促销");
	    activity.setNote("耐克大促销");
	    activity.setImgPath("www.zhq.com/91");
	    activity.setStartTime(new Date());
	    activity.setEndTime(new Date());
	    activityDao.insert(activity);;
		session.commit();
		session.close();
	}
	
	@Test
	public void update(){
		SqlSession session = sqlSessionFactory.openSession();
		ActivityDao activityDao = session.getMapper(ActivityDao.class);
	    Activity activity = activityDao.selectById(10);
	    activity.setId(10);
	    activity.setTitle("爱打游戏");
	    activity.setNote("爱打游戏");
	    activity.setStartTime(new Date());
	    activity.setEndTime(new Date());
	    activityDao.update(activity);
		session.commit();
		session.close();
	}
	
	@Test
	public void delete(){
		SqlSession session = sqlSessionFactory.openSession();
		ActivityDao activityDao = session.getMapper(ActivityDao.class);
	    activityDao.destroy(10);;
		session.commit();
		session.close();
	}

}
