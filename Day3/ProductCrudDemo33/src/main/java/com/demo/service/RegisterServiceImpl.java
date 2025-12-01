package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.dao.RegisterDao;
import com.demo.dao.RegisterDaoImpl;

public class RegisterServiceImpl implements RegisterService {
    private RegisterDao rdao;

    public RegisterServiceImpl() {
        rdao = new RegisterDaoImpl();
    }

    @Override
    public boolean register(MyUser user, String password) {
        return rdao.registerUser(user, password);
    }
}
