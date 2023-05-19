package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysInterUrl;
import com.fc.v2.model.auto.SysInterUrlExample;
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
public interface SysInterUrlService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysInterUrl> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysInterUrl selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysInterUrl record);

    int insertSelective(SysInterUrl record);

    int updateByExampleSelective(SysInterUrl record, SysInterUrlExample example);

    int updateByExample(SysInterUrl record, SysInterUrlExample example);

    List<SysInterUrl> selectByExample(SysInterUrlExample example);

    long countByExample(SysInterUrlExample example);

    int deleteByExample(SysInterUrlExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(SysInterUrl sysDepartment);

}
