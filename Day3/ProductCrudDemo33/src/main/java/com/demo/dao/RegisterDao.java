
package com.demo.dao;

import com.demo.beans.MyUser;

public interface RegisterDao {
    boolean registerUser(MyUser user, String password);
}
