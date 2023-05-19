package com.fc.v2.service.system;

import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
import com.fc.v2.model.auto.TSysEmail;
import com.fc.v2.model.auto.TSysEmailExample;
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
public interface SysEmailService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<TSysEmail> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    TSysEmail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSysEmail record);

    int insertSelective(TSysEmail record);

    int updateByExampleSelective(TSysEmail record, TSysEmailExample example);

    int updateByExample(TSysEmail record, TSysEmailExample example);

    List<TSysEmail> selectByExample(TSysEmailExample example);

    long countByExample(TSysEmailExample example);

    int deleteByExample(TSysEmailExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(TSysEmail sysDepartment);

}
