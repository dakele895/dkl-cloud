package com.dkl.dao.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.dkl.dao.BaseDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author: dalele
 * @date: 2020/3/18 15:43
 * @description:
 */
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Qualifier("baseMapper2")
	private BaseMapper<T> baseMapper;


	@Override
	public int insert(T entity) {

		return baseMapper.insert(entity);
	}

	@Override
	public int deleteById(Serializable id) {
		return 0;
	}

	@Override
	public int deleteByMap(Map<String, Object> columnMap) {
		return 0;
	}

	@Override
	public int delete(Wrapper<T> wrapper) {
		return 0;
	}

	@Override
	public int deleteBatchIds(Collection<? extends Serializable> idList) {
		return 0;
	}

	@Override
	public int updateById(T entity) {
		return 0;
	}

	@Override
	public int update(T entity, Wrapper<T> updateWrapper) {
		return 0;
	}

	@Override
	public T selectById(Serializable id) {
		return null;
	}

	@Override
	public List<T> selectBatchIds(Collection<? extends Serializable> idList) {
		return null;
	}

	@Override
	public List<T> selectByMap(Map<String, Object> columnMap) {
		return null;
	}

	@Override
	public T selectOne(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public Integer selectCount(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public List<T> selectList(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public List<Map<String, Object>> selectMaps(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public List<Object> selectObjs(Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public IPage<T> selectPage(IPage<T> page, Wrapper<T> queryWrapper) {
		return null;
	}

	@Override
	public IPage<Map<String, Object>> selectMapsPage(IPage<T> page, Wrapper<T> queryWrapper) {
		return null;
	}
}
