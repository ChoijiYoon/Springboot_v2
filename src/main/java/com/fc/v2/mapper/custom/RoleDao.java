package com.fc.v2.mapper.custom;

import com.fc.v2.model.auto.TsysRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色Dao
 * @ClassName: RoleDao
 * @author fuce
 * @date 2018年8月25日
 *
 */
@Repository
public interface RoleDao {
	/**
	 * 根据用户id查询角色
	 * @param userid
	 * @return
	 */
	public List<TsysRole> queryUserRole(String userid);
	
	/**
	 * 根据用户id查询角色id 
	 * @param userid
	 * @return
	 */
	public List<String> queryUserRoleId(String userid);
	
}
