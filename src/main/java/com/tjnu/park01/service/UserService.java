package com.tjnu.park01.service;

import com.tjnu.park01.domain.User;

public interface UserService {
    public User queryUserById(long id);
    public String register(String username, String password);
    public String login(String username,String password);
}
