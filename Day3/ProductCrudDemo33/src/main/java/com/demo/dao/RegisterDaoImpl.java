package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.demo.beans.MyUser;

public class RegisterDaoImpl implements RegisterDao {
    static Connection conn = null;
    static PreparedStatement insertUser;

    static {
        try {
            conn = DBUtil.getMyConnection();
            insertUser = conn.prepareStatement(
                "INSERT INTO user1(uname,email,password,role,gender,hobbies,city) VALUES(?,?,?,?,?,?,?)"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean registerUser(MyUser user, String password) {
        try {
            insertUser.setString(1, user.getUname());
            insertUser.setString(2, user.getEmail());
            insertUser.setString(3, password);
            insertUser.setString(4, "customer"); // default role
            insertUser.setString(5, user.getGender());
            insertUser.setString(6, user.getHobbies());
            insertUser.setString(7, user.getCity());

            int count = insertUser.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
