package homework18.services;

import homework18.entities.User;

public interface UserServiceThree {
    default String getUserName(User user) {
        return  "DEFAULT NAME IS IGOR";
    }
    static void print (User user) {
        System.out.println("Print user three: " + user);
    }

    void login (User user);
    void logout (User user);
}
