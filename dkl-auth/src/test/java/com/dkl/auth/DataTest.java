package com.dkl.auth;

import com.dkl.dao.SysUserDao;
import com.dkl.entity.system.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: dalele
 * @date: 2020/3/19 00:14
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.dkl.mapper")
@ComponentScan("com.dkl.dao")
public class DataTest {


	@Autowired
	private SysUserDao sysUserDao;

	@Test
	public void query(){

		SysUser dkl = sysUserDao.findByName("dkl");
		System.out.println(dkl.toString());

	}


}
