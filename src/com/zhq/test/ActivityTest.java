package com.zhq.test;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
	public void test() {
		SqlSession session = sqlSessionFactory.openSession();
		Activity activity = session.selectOne("com.zhq.dao.ActivityDao.selectById",10);
		session.commit();
		System.out.println(activity);
		Assert.assertNotEquals("查找成功", "爱美丽", activity.getTitle());
		session.close();
	}

}
