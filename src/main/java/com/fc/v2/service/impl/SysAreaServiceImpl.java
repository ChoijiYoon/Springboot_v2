package com.fc.v2.service.impl;

import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.SysAreaMapper;
import com.fc.v2.model.auto.SysArea;
import com.fc.v2.model.auto.SysAreaExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.service.SysAreaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 地区设置 SysAreaService
 * @Title: SysAreaService.java
 * @Package com.fc.v2.service
 * @author fuce_自动生成
 * @email 115889198@qq.com
 * @date 2019-10-04 21:47:38
 **/
@Service
public class SysAreaServiceImpl implements SysAreaService {
	@Autowired
	private SysAreaMapper sysAreaMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param name
	 * @return
	 */
	@Override
	 public PageInfo<SysArea> list(Tablepar tablepar,String name){
		
	        SysAreaExample testExample=new SysAreaExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andAreaNameLike("%"+name+"%");
	        }
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<SysArea> list= sysAreaMapper.selectByExample(testExample);
	        PageInfo<SysArea> pageInfo = new PageInfo<SysArea>(list);
	       
	        return  pageInfo;
	 }

	 @Override
	public int deleteByPrimaryKey(String ids) {
		Integer[] integers = ConvertUtil.toIntArray(",", ids);
		List<Integer> stringB = Arrays.asList(integers);
		SysAreaExample example=new SysAreaExample();
		example.createCriteria().andIdIn(stringB);
		return sysAreaMapper.deleteByExample(example);
	}
	
	
	@Override
	public SysArea selectByPrimaryKey(Integer id) {
		
		return sysAreaMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int updateByPrimaryKeySelective(SysArea record) {
		return sysAreaMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(SysArea record) {
		//添加雪花主键id
		record.setId(null);
		return sysAreaMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(SysArea record, SysAreaExample example) {
		
		return sysAreaMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(SysArea record, SysAreaExample example) {
		
		return sysAreaMapper.updateByExample(record, example);
	}

	@Override
	public List<SysArea> selectByExample(SysAreaExample example) {
		
		return sysAreaMapper.selectByExample(example);
	}
	
	@Override
	public long countByExample(SysAreaExample example) {
		
		return sysAreaMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysAreaExample example) {
		
		return sysAreaMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param sysArea
	 * @return
	 */
	@Override
	public int checkNameUnique(SysArea sysArea){
		SysAreaExample example=new SysAreaExample();
		example.createCriteria().andAreaNameEqualTo(sysArea.getAreaName());
		List<SysArea> list=sysAreaMapper.selectByExample(example);
		return list.size();
	}


}
