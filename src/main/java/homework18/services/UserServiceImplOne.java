package homework18.services;

import homework18.entities.User;

public class UserServiceImplOne implements UserServiceOne, UserServiceTwo {


    @Override
    public void login(User user) {

    }

    @Override
    public void logout(User user) {

    }

    //    в этом случае переопределим дефолтный метод для исправления ошибки компиляции:
    @Override
    public String getUserName(User user) {
        return user.getName();
    }

}
