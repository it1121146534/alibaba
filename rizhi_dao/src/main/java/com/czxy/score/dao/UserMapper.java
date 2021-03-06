package com.czxy.score.dao;

import com.czxy.score.domain.User;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    @Select("select * from tab_user where username = #{username} and password = #{password}")
    User login(User user);
}
