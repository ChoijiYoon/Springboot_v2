package com.fc.v2.service;

import com.fc.v2.model.auto.SysArea;
import com.fc.v2.model.auto.SysAreaExample;
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
public interface SysAreaService {
    /**
     * 分页查询
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysArea> list(Tablepar tablepar, String name);


    int deleteByPrimaryKey(String ids) ;

    SysArea selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysArea record);

    int insertSelective(SysArea record);

    int updateByExampleSelective(SysArea record, SysAreaExample example);

    int updateByExample(SysArea record, SysAreaExample example);

    List<SysArea> selectByExample(SysAreaExample example);

    long countByExample(SysAreaExample example);

    int deleteByExample(SysAreaExample example);

    /**
     * 检查name
     * @param sysArea
     * @return
     */
    int checkNameUnique(SysArea sysArea);
}
