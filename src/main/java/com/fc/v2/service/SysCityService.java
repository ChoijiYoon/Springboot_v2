package com.fc.v2.service;

import com.fc.v2.model.auto.SysCity;
import com.fc.v2.model.auto.SysCityExample;
import com.fc.v2.model.auto.TSysDictData;
import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 描述：
 *
 * @author https:www.unfbx.com
 * @date 2023-04-08
 */
public interface SysCityService {
    /**
     * 分页查询
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysCity> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysCity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysCity record);

    int insertSelective(SysCity record);

    int updateByExampleSelective(SysCity record, SysCityExample example);

    int updateByExample(SysCity record, SysCityExample example);

    List<SysCity> selectByExample(SysCityExample example);

    long countByExample(SysCityExample example);

    int deleteByExample(SysCityExample example);

    int checkNameUnique(SysCity sysCity);
}
