package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysStreet;
import com.fc.v2.model.auto.SysStreetExample;
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
public interface SysStreetService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysStreet> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysStreet selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysStreet record);

    int insertSelective(SysStreet record);

    int updateByExampleSelective(SysStreet record, SysStreetExample example);

    int updateByExample(SysStreet record, SysStreetExample example);

    List<SysStreet> selectByExample(SysStreetExample example);

    long countByExample(SysStreetExample example);

    int deleteByExample(SysStreetExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(SysStreet sysDepartment);

}
