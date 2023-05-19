package com.fc.v2.service.system;

import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
import com.fc.v2.model.auto.TsysRole;
import com.fc.v2.model.auto.TsysRoleExample;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门：
 *
 * @author cgy
 * @version 1.0
 * @date 2023/5/18 18:05
 */
public interface SysRoleService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @return
     */
    PageInfo<TsysRole> list(Tablepar tablepar);

    int deleteByPrimaryKey(String ids);

    TsysRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsysRole record);

    int insertSelective(TsysRole record);

    int updateByExampleSelective(TsysRole record, TsysRoleExample example);

    int updateByExample(TsysRole record, TsysRoleExample example);

    List<TsysRole> selectByExample(TsysRoleExample example);

    long countByExample(TsysRoleExample example);

    int deleteByExample(TsysRoleExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkNameUnique(TsysRole sysDepartment);

    /**
     * 查询全部角色集合
     * @return
     */
    List<TsysRole> queryList();

    /**
     * 添加角色绑定权限
     * @param record 角色信息
     * @param prem 权限id集合
     * @return
     */
    int insertRoleAndPrem(TsysRole record,String prem);

    /**
     * 修改用户角色 以及下面绑定的权限
     *
     * @Author cgy
     * @Date 13:34 2023/5/19
     * @Param
     * @param roleId
     * @param powerIds
     * @return
     * @return int
     **/
    int updateRoleAndPrem(String roleId,String powerIds);

    /**
     * 根据用户id查询角色
     * @param userid
     * @return
     */
    List<TsysRole> queryUserRole(String userid);
}
