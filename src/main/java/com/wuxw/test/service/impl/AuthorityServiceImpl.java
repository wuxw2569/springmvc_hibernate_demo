package com.wuxw.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wuxw.test.dao.AuthorityDao;
import com.wuxw.test.entity.AcctAuthority;
import com.wuxw.test.service.AuthorityService;

/**
 * 创建时间：2015-2-6 下午3:24:16
 * 
 * @author andy
 * @version 2.2 
 * AuthorityService 的实现
 */
@Service("authorityService")
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityDao authorityDao;

	@Override
	public AcctAuthority load(String id) {
		return authorityDao.load(id);
	}

	@Override
	public AcctAuthority get(String id) {
		return authorityDao.get(id);
	}

	@Override
	public List<AcctAuthority> findAll() {
		return authorityDao.findAll();
	}

	@Override
	public void persist(AcctAuthority entity) {
		authorityDao.persist(entity);
	}

	@Override
	public String save(AcctAuthority entity) {
		return authorityDao.save(entity);
	}

	@Override
	public void saveOrUpdate(AcctAuthority entity) {
		authorityDao.saveOrUpdate(entity);
	}

	@Override
	public void delete(String id) {
		authorityDao.delete(id);
	}

	@Override
	public void flush() {
		authorityDao.flush();
	}

}
