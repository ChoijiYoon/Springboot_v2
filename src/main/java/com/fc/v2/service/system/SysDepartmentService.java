package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysDepartment;
import com.fc.v2.model.auto.SysDepartmentExample;
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
public interface SysDepartmentService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
     PageInfo<SysDepartment> list(Tablepar tablepar, String name);

     int deleteByPrimaryKey(String ids);

     SysDepartment selectByPrimaryKey(String id);

     int updateByPrimaryKeySelective(SysDepartment record);

     int insertSelective(SysDepartment record);

     int updateByExampleSelective(SysDepartment record, SysDepartmentExample example);

     int updateByExample(SysDepartment record, SysDepartmentExample example);

     List<SysDepartment> selectByExample(SysDepartmentExample example);

     long countByExample(SysDepartmentExample example);

     int deleteByExample(SysDepartmentExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
     int checkNameUnique(SysDepartment sysDepartment);

    /**
     * 修改权限状态展示或者不展示
     * @param record
     * @return
     */
     int updateVisible(SysDepartment record);
    
    
}
