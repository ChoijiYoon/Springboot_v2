package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysFile;
import com.fc.v2.model.auto.SysFileExample;
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
public interface SysFileService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<SysFile> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    SysFile selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysFile record);

    int insertSelective(SysFile record);

    int updateByExampleSelective(SysFile record, SysFileExample example);

    int updateByExample(SysFile record, SysFileExample example);

    List<SysFile> selectByExample(SysFileExample example);

    long countByExample(SysFileExample example);

    int deleteByExample(SysFileExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(SysFile sysDepartment);

    /**
     * 修改信息
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(SysFile record);

    SysFile selectByExamplefileName(String filename);

}
