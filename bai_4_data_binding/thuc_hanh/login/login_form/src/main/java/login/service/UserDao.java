package login.service;

import login.model.Login;
import login.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        users.add(new User("john123","123456","John","john@codegym.vn",10));
        users.add(new User("bill123","123456","Bill","bill@codegym.vn",15));
        users.add(new User("mike123","123456","Mike","mike@codegym.vn",16));
    }

    public static User checkLogin(Login login){
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}