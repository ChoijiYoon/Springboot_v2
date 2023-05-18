package com.fc.test.mapper.auto;

import com.fc.test.model.auto.UserMessageHistory;
import com.fc.test.model.auto.UserMessageHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMessageHistoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    long countByExample(UserMessageHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    int deleteByExample(UserMessageHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    int insert(UserMessageHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    int insertSelective(UserMessageHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    List<UserMessageHistory> selectByExample(UserMessageHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    UserMessageHistory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserMessageHistory record, @Param("example") UserMessageHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserMessageHistory record, @Param("example") UserMessageHistoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserMessageHistory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table us_message_history
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserMessageHistory record);
}