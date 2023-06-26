package com.fc.v2.mapper.custom;

import com.fc.v2.model.xuper.XuperAccount;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface XuperAccountDao {

	/**
	 * 新增账户
	 * @Author cgy
	 * @Date 17:32 2023/6/26
	 * @Param
	 * @param xuperAccount
	 * @return
	 * @return java.lang.Long
	 **/
	Long insert(XuperAccount xuperAccount);

	/**
	 * 根据用户id查询对应账户信息
	 * @Author cgy
	 * @Date 17:35 2023/6/26
	 * @Param
	 * @param userId
	 * @return
	 * @return com.fc.v2.model.xuper.XuperAccount
	 **/
	XuperAccount getByUserId(@Param("userId") Long userId);

}
