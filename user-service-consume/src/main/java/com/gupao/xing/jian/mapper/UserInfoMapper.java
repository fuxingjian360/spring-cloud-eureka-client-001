package com.gupao.xing.jian.mapper;

import com.gupao.xing.jian.domain.UserInfo;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface UserInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info_t
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info_t
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    int insert(UserInfo record
    );

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info_t
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    int insertSelective(UserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info_t
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    UserInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info_t
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    int updateByPrimaryKeySelective(UserInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info_t
     *
     * @mbg.generated Sun Mar 29 09:07:03 CST 2020
     */
    int updateByPrimaryKey(UserInfo record);
}