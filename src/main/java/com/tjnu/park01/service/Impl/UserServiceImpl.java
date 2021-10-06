package com.tjnu.park01.service.Impl;

import com.tjnu.park01.domain.User;
import com.tjnu.park01.domain.UserExample;
import com.tjnu.park01.mapper.UserMapper;
import com.tjnu.park01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User queryUserById(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public String register(String username, String password) {
        User user=new User();
        user.setPassword(password);
        user.setUsername(username);
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> list=userMapper.selectByExample(userExample);
        if(list.isEmpty()){
            userMapper.insert(user);
            return "Ok";
        }else{
            return "Error";
        }

    }


    @Override
    public String login(String username, String password){
        User user=new User();
        user.setPassword(password);
        user.setUsername(username);
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> list=userMapper.selectByExample(userExample);
        if(list.isEmpty()){
            return "Error";
        }else{
            return "OK";
        }
    }
}
