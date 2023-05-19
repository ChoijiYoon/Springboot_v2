package com.fc.v2.service.system;

import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
import com.fc.v2.model.auto.TsysUser;
import com.fc.v2.model.auto.TsysUserExample;
import com.fc.v2.model.custom.RoleVo;
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
public interface SysUserService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<TsysUser> list(Tablepar tablepar);

    int deleteByPrimaryKey(String ids);

    TsysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsysUser record);

    int insertSelective(TsysUser record);

    int updateByExampleSelective(TsysUser record, TsysUserExample example);

    int updateByExample(TsysUser record, TsysUserExample example);

    List<TsysUser> selectByExample(TsysUserExample example);

    long countByExample(TsysUserExample example);

    int deleteByExample(TsysUserExample example);

    /**
     * 检查name
     *
     * @param sysDepartment
     * @return
     */
    int checkLoginNameUnique(TsysUser sysDepartment);

    /**
     * 获取所有权限 并且增加是否有权限字段
     * @return
     */
    List<RoleVo> getUserIsRole(String userid);

    /**
     * 修改用户密码
     * @param record
     * @return
     */
    int updateUserPassword(TsysUser record);

    /**
     * 修改用户信息以及角色信息
     * @param record
     * @param roleIds
     * @return
     */
    int updateUserRoles(TsysUser record,String roleIds);

    /**
     * 添加用户跟角色信息
     * @param record
     * @param roles
     * @return
     */
    int insertUserRoles(TsysUser record,String roles);

}
