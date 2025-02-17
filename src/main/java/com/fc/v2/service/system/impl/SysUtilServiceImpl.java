package com.fc.v2.service.system.impl;

import com.fc.v2.mapper.custom.SysUtilDao;
import com.fc.v2.model.custom.SQLAdapter;
import com.fc.v2.service.system.SysUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysUtilServiceImpl implements SysUtilService {
	@Autowired
	private SysUtilDao dao;
	
	/**
	 * 执行sql
	 * @param sql
	 * @return
	 * @author fuce
	 * @Date 2019年8月31日 下午6:15:08
	 */
	@Override
	public int executeSQL(String sql){
		return dao.executeSQL(new SQLAdapter(sql));
	}
	
	
	/**
	 * 查询sql
	 * @param sql
	 * @return list<map>
	 * @author fuce
	 * @Date 2020年4月10日 下午4:55:49
	 */
	@Override
	public List<Map<Object,Object>> SelectExecuteSQL(String sql){
		return dao.SelectExecuteSQL(new SQLAdapter(sql));
	}
}
