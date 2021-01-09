package homework18.services;

import homework18.entities.User;

public interface UserServiceTwo {
    default String getUserName(User user) {
        return  "user.getName()";
    }
    static void print (User user) {
        System.out.println("Print user two: " + user);
    }

    void login (User user);
    void logout (User user);
}
