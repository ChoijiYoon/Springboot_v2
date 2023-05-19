package com.fc.v2.service.system;

import com.fc.v2.model.auto.TSysDictType;
import com.fc.v2.model.auto.TSysDictTypeExample;
import com.fc.v2.model.auto.TsysPermission;
import com.fc.v2.model.auto.TsysPermissionExample;
import com.fc.v2.model.custom.SysMenu;
import com.fc.v2.model.custom.SysPower;
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
public interface SysPermissionService {

    /**
     * 分页查询
     *
     * @param tablepar
     * @param name
     * @return
     */
    PageInfo<TsysPermission> list(Tablepar tablepar, String name);

    int deleteByPrimaryKey(String ids);

    TsysPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TsysPermission record);

    int insertSelective(TsysPermission record);

    int updateByExampleSelective(TsysPermission record, TsysPermissionExample example);

    int updateByExample(TsysPermission record, TsysPermissionExample example);

    List<TsysPermission> selectByExample(TsysPermissionExample example);

    long countByExample(TsysPermissionExample example);

    int deleteByExample(TsysPermissionExample example);

    /**
     * 修改权限状态展示或者不展示
     *
     * @param record
     * @return
     */
    int updateVisible(TsysPermission record);

    /**
     * 检查权限名字
     *
     * @param tsysPermission
     * @return
     */
    int checkNameUnique(TsysPermission tsysPermission);

    /**
     * 检查权限URL
     *
     * @param tsysPermission
     * @return
     */
    int checkURLUnique(TsysPermission tsysPermission);

    /**
     * 检查权限perms字段
     *
     * @param tsysPermission
     * @return
     */
    int checkPermsUnique(TsysPermission tsysPermission);

    /**
     * 根据父id 以及类型查询权限子集
     *
     * @param pid
     * @return
     */
    List<TsysPermission> queryPid(String pid, int type);

    /**
     * 根据用户id查询菜单栏
     *
     * @return
     */
    List<SysMenu> getSysMenus(String userid);

    /**
     * 根据角色id查询所有权限，权限有会有标识表示
     *
     * @return
     */
    List<SysPower> getRolePower(String roleId);

    /**
     * 根据用户id获取用户角色如果用户为null 获取所有权限
     *
     * @return
     */
    List<TsysPermission> getall(String userid);

    /**
     * 根据权限字段查询是否存在
     *
     * @param perms
     * @return
     * @author fuce
     * @Date 2019年9月1日 上午2:06:31
     */
    Boolean queryLikePerms(String perms);

    int updateByPrimaryKey(TsysPermission record);

}
