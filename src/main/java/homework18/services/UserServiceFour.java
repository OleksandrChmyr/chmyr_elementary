package homework18.services;

import homework18.entities.User;

public interface UserServiceFour extends UserServiceThree{
    default String getUserName(User user) {
        return  "Default NAME is OLEG";
    }
    static void print (User user) {
        System.out.println("Print user four: " + user);
    }

    void login (User user);
    void logout (User user);
}
