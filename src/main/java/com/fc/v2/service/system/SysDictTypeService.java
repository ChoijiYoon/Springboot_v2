package com.fc.v2.service.system;

import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 部门：
 *
 * @author cgy
 * @version 1.0
 * @date 2023/5/18 18:05
 */
public interface SysDictTypeService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<TSysDictType> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    TSysDictType selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSysDictType record);

    int insertSelective(TSysDictType record);

    int updateByExampleSelective(TSysDictType record, TSysDictTypeExample example);

    int updateByExample(TSysDictType record, TSysDictTypeExample example);

    List<TSysDictType> selectByExample(TSysDictTypeExample example);

    long countByExample(TSysDictTypeExample example);

    int deleteByExample(TSysDictTypeExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(TSysDictType sysDepartment);

}
