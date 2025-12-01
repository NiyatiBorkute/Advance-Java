package com.demo.service;

import com.demo.beans.MyUser;

public interface RegisterService {
    boolean register(MyUser user, String password);
}
