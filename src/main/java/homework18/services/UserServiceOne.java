package homework18.services;

import homework18.entities.User;

public interface UserServiceOne {

    default String getUserName(User user) {
        return  "DefaultUserName";
    }
    static void print (User user) {
        System.out.println("Print user one: " + user);
    }

    void login (User user);
    void logout (User user);
}
