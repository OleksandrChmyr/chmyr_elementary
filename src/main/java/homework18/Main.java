package homework18;

import homework18.entities.User;
import homework18.services.*;
import homework18.utils.NumberToWord;
import homework18.utils.OptionalHelperClass;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
// 4. В классе Main реализовать вызов всех возможных методов;

//        Статические:

        User user = new User("Alex");
        UserServiceOne.print(user);
        UserServiceTwo.print(user);
        UserServiceThree.print(user);
        UserServiceFour.print(user);

//        Дефолтные:

        UserServiceImplOne userServiceImplOne = new UserServiceImplOne();
        userServiceImplOne.getUserName(user);
        UserServiceImplTwo userServiceImplTwo = new UserServiceImplTwo();
        userServiceImplTwo.getUserName(user);

//        Прочие методы:

        userServiceImplOne.login(user);
        userServiceImplOne.logout(user);
        userServiceImplTwo.login(user);
        userServiceImplTwo.login(user);


        OptionalHelperClass optionalHelperClass = new OptionalHelperClass();

        System.out.println(optionalHelperClass.optionalHelperMethod("email@gmail.com"));
        System.out.println(optionalHelperClass.optionalHelperMethod("email"));
        System.out.println(optionalHelperClass.optionalHelperMethod(""));

//8. Используя функциональные интерфейсы написать следующие функции:
//8.1. Predicate: метод, который на вход принимает дробное значение зарплаты.
// Если это значение больше 1500.0, то возвращает значение true;
        Predicate<Double> doublePredicate = salary -> salary > 1500.0;
        System.out.println(doublePredicate.test(16660.0));
        System.out.println(doublePredicate.test(160.0));
//8.2. Consumer: метод, который на вход принимает строку, преобразует ее в массив символов и потом печатает эти
// символы в консоль в виде символов, а не строки;
//        Consumer <String> resultConsumer = str -> System.out.println(str.toCharArray());
//        resultConsumer.accept("HelloHillel");

        Consumer<String> resultConsumer = str -> {
            char[] result = str.toCharArray();

            System.out.println("Char array:");
            for (int i = 0; i < result.length; i++)
                System.out.println("Element [" + i + "]: " + result[i]);
        };
        resultConsumer.accept("Hello hillel");
//8.3. Function: метод, который на вход принимает целое число от 1 до 10, а возвращает строку в соответствии этому
// числу, только словом. Например: 3 -> “three”. Если число вне диапазона, то возвращать слово “unknown”;

        Function<Integer, String> resultFunction = i -> {
            if (i <= 10 & i >= 1) {

                return String.valueOf(NumberToWord.convert(i));
            } else {
                return "unknown";
            }
        };
        System.out.println(resultFunction.apply(1));
        System.out.println(resultFunction.apply(6));
        System.out.println(resultFunction.apply(9));
        System.out.println(resultFunction.apply(11));

//8.4. Supplier: метод, который возвращает любое значение на Ваше усмотрение;

        Supplier<String> resultSupplier = () -> user.getName();
        System.out.println(resultSupplier.get());

    }

}

