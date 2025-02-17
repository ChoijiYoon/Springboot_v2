package com.fc.v2.service.system.impl;

import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.SysProvinceMapper;
import com.fc.v2.model.auto.SysProvince;
import com.fc.v2.model.auto.SysProvinceExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.service.system.SysProvinceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 省份表 SysProvinceService
 * @Title: SysProvinceService.java
 * @Package com.fc.v2.service
 * @author fuce_自动生成
 * @email 115889198@qq.com
 * @date 2019-10-04 19:56:15
 **/
@Service
public class SysProvinceServiceImpl implements SysProvinceService {
	@Autowired
	private SysProvinceMapper sysProvinceMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param name
	 * @return
	 */
	@Override
	 public PageInfo<SysProvince> list(Tablepar tablepar,String name){
	        SysProvinceExample testExample=new SysProvinceExample();
	        testExample.setOrderByClause("id ASC");
	        if(name!=null&&!"".equals(name)){
	        	testExample.createCriteria().andProvinceNameLike("%"+name+"%");
	        }

	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<SysProvince> list= sysProvinceMapper.selectByExample(testExample);
	        PageInfo<SysProvince> pageInfo = new PageInfo<SysProvince>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
		Integer[] integers = ConvertUtil.toIntArray(",", ids);
		List<Integer> stringB = Arrays.asList(integers);
		SysProvinceExample example=new SysProvinceExample();
		example.createCriteria().andIdIn(stringB);
		return sysProvinceMapper.deleteByExample(example);
	}


	@Override
	public SysProvince selectByPrimaryKey(Integer id) {
		
		return sysProvinceMapper.selectByPrimaryKey(id);
	}


	@Override
	public int updateByPrimaryKeySelective(SysProvince record) {
		return sysProvinceMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(SysProvince record) {
		//添加主键id
		record.setId(null);
		return sysProvinceMapper.insertSelective(record);
	}


	@Override
	public int updateByExampleSelective(SysProvince record, SysProvinceExample example) {
		
		return sysProvinceMapper.updateByExampleSelective(record, example);
	}


	@Override
	public int updateByExample(SysProvince record, SysProvinceExample example) {
		
		return sysProvinceMapper.updateByExample(record, example);
	}

	@Override
	public List<SysProvince> selectByExample(SysProvinceExample example) {
		
		return sysProvinceMapper.selectByExample(example);
	}


	@Override
	public long countByExample(SysProvinceExample example) {
		
		return sysProvinceMapper.countByExample(example);
	}


	@Override
	public int deleteByExample(SysProvinceExample example) {
		
		return sysProvinceMapper.deleteByExample(example);
	}
	
	/**
	 * 检查name
	 * @param sysProvince
	 * @return
	 */
	@Override
	public int checkNameUnique(SysProvince sysProvince){
		SysProvinceExample example=new SysProvinceExample();
		example.createCriteria().andProvinceNameEqualTo(sysProvince.getProvinceName());
		List<SysProvince> list=sysProvinceMapper.selectByExample(example);
		return list.size();
	}


}
