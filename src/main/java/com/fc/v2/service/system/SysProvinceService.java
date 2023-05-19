package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysProvince;
import com.fc.v2.model.auto.SysProvinceExample;
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
public interface SysProvinceService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysProvince> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    int updateByPrimaryKeySelective(SysProvince record);

    int insertSelective(SysProvince record);

    int updateByExampleSelective(SysProvince record, SysProvinceExample example);

    int updateByExample(SysProvince record, SysProvinceExample example);

    List<SysProvince> selectByExample(SysProvinceExample example);

    long countByExample(SysProvinceExample example);

    int deleteByExample(SysProvinceExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(SysProvince sysDepartment);

    SysProvince selectByPrimaryKey(Integer id);

}
