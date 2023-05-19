package com.fc.v2.service.system.impl;

import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.SysCityMapper;
import com.fc.v2.model.auto.SysCity;
import com.fc.v2.model.auto.SysCityExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.service.system.SysCityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 城市设置 SysCityService
 * @Title: SysCityService.java
 * @Package com.fc.v2.service
 * @author fuce_自动生成
 * @email 115889198@qq.com
 * @date 2019-10-04 21:15:13
 **/
@Service
public class SysCityServiceImpl implements SysCityService {
	@Autowired
	private SysCityMapper sysCityMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param name
	 * @return
	 */
	@Override
	public PageInfo<SysCity> list(Tablepar tablepar,String name){
	        SysCityExample testExample=new SysCityExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andCityNameLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<SysCity> list= sysCityMapper.selectByExample(testExample);
	        PageInfo<SysCity> pageInfo = new PageInfo<SysCity>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		Integer[] integers = ConvertUtil.toIntArray(",", ids);
		List<Integer> stringB = Arrays.asList(integers);
		SysCityExample example=new SysCityExample();
		example.createCriteria().andIdIn(stringB);
		return sysCityMapper.deleteByExample(example);
	}


	@Override
	public SysCity selectByPrimaryKey(Integer id) {
		return sysCityMapper.selectByPrimaryKey(id);
	}


	@Override
	public int updateByPrimaryKeySelective(SysCity record) {
		return sysCityMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(SysCity record) {
		//添加雪花主键id
		record.setId(null);
		return sysCityMapper.insertSelective(record);
	}


	@Override
	public int updateByExampleSelective(SysCity record, SysCityExample example) {
		
		return sysCityMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int updateByExample(SysCity record, SysCityExample example) {
		
		return sysCityMapper.updateByExample(record, example);
	}

	@Override
	public List<SysCity> selectByExample(SysCityExample example) {
		
		return sysCityMapper.selectByExample(example);
	}


	@Override
	public long countByExample(SysCityExample example) {
		
		return sysCityMapper.countByExample(example);
	}


	@Override
	public int deleteByExample(SysCityExample example) {
		
		return sysCityMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param sysCity
	 * @return
	 */
	@Override
	public int checkNameUnique(SysCity sysCity){
		SysCityExample example=new SysCityExample();
		example.createCriteria().andCityNameEqualTo(sysCity.getCityName());
		List<SysCity> list=sysCityMapper.selectByExample(example);
		return list.size();
	}


}
