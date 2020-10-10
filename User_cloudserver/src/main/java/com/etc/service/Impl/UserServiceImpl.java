package com.etc.service.Impl;

import com.etc.dao.UserDao;
import com.etc.entity.User;
import com.etc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;


    @Override
    public User getUserById(Integer id) {
        return userDao.findUserByUid(id);
    }
}
