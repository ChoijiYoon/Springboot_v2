package com.fc.v2.mapper.auto;

import com.fc.v2.model.auto.TSysRoleUser;
import com.fc.v2.model.auto.TSysRoleUserExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TSysRoleUserMapper {
    int countByExample(TSysRoleUserExample example);

    int deleteByExample(TSysRoleUserExample example);

    int deleteByPrimaryKey(String id);

    int insert(TSysRoleUser record);

    int insertSelective(TSysRoleUser record);

    List<TSysRoleUser> selectByExample(TSysRoleUserExample example);

    TSysRoleUser selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TSysRoleUser record, @Param("example") TSysRoleUserExample example);

    int updateByExample(@Param("record") TSysRoleUser record, @Param("example") TSysRoleUserExample example);

    int updateByPrimaryKeySelective(TSysRoleUser record);

    int updateByPrimaryKey(TSysRoleUser record);
}