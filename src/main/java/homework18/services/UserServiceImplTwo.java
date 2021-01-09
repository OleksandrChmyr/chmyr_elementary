package homework18.services;

import homework18.entities.User;

public class UserServiceImplTwo implements UserServiceThree, UserServiceFour{
    @Override
    public void login(User user) {

    }

    @Override
    public void logout(User user) {

    }

    // Тут исправление ошибки компиляции путем определения наследования интерфейсов
}
