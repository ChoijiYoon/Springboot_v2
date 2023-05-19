package com.fc.v2.service.system;

import com.fc.v2.model.auto.SysDepartment;
import com.fc.v2.model.auto.SysDepartmentExample;
import com.fc.v2.model.auto.TSysDictData;
import com.fc.v2.model.auto.TSysDictDataExample;
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
public interface SysDictDataService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<TSysDictData> list(Tablepar tablepar, String name, String dictId);

    int deleteByPrimaryKey(String ids);

    TSysDictData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TSysDictData record);

    int insertSelective(TSysDictData record);

    int updateByExampleSelective(TSysDictData record, TSysDictDataExample example);

    int updateByExample(TSysDictData record, TSysDictDataExample example);

    List<TSysDictData> selectByExample(TSysDictDataExample example);

    long countByExample(TSysDictDataExample example);

    int deleteByExample(TSysDictDataExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(TSysDictData sysDepartment);

    /**
     * 批量删除
     *
     * @param dictIds
     * @author fuce
     * @Date 2019年9月9日 上午12:40:52
     */
    void deleteByPrimaryDictIds(List<String> dictIds);


}
