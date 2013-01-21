package com.proj.services;

import com.proj.entities.User;

/**
 * Created with IntelliJ IDEA.
 * User: dima
 * Date: 21.01.13
 * Time: 15:27
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {

    User save(User user);
    User findOne(String id);
}
