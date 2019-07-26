package com.czxy.score.service.impl;

import com.czxy.score.dao.UserMapper;
import com.czxy.score.domain.User;
import com.czxy.score.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @version v 1.0
 * @date 2019/7/25
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
}
