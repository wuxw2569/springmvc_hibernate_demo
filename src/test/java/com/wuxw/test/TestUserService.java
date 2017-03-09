package com.wuxw.test;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wuxw.test.entity.AcctRole;
import com.wuxw.test.entity.AcctUser;
import com.wuxw.test.service.UserService;

/**
 * 创建时间：2015-2-6 下午3:31:07
 * 
 * @author andy
 * @version 2.2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-hibernate.xml" })

public class TestUserService extends  AbstractTransactionalJUnit4SpringContextTests{

	private static final Logger LOGGER = Logger
			.getLogger(TestUserService.class);

	@Autowired
	private UserService userService;

	@Test
	public void save() {
		AcctUser acctUser = new AcctUser();
		acctUser.setId(UUID.randomUUID().toString());
		acctUser.setNickName("andy");
		acctUser.setRegisterTime(new Date());
		acctUser.setTelephone("13022221111");
		String id = userService.save(acctUser);
		LOGGER.info(JSON.toJSONString(id));
	}

	@Test
	public void load() {
		 AcctUser acctUser = userService.get("6e5afb1d-50e1-45fe-b6fe-b9e399415387");          
	        
         Set<AcctRole> addset=acctUser.getAcctRoles();  
         for (Iterator iterator = addset.iterator(); iterator.hasNext();) {
			AcctRole acctRole = (AcctRole) iterator.next();
			System.out.println(acctRole.getName());
		}
	}

}
