package homework21;

import homework21.deadlock.Admin;
import homework21.deadlock.User;
import homework21.threads.CallableExample;
import homework21.threads.RunnableExample;
import homework21.threads.ThreadExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class Main {



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadExample threadExample = new ThreadExample();
        threadExample.setName("Example 1 - Thread: ");
        threadExample.start();
        threadExample.join();



        RunnableExample runnableExample = new RunnableExample();
        Thread threadRunnable = new Thread(runnableExample);
        threadRunnable.setName("Example 2 - Runnable: ");
        threadRunnable.start();
        threadRunnable.join();

        CallableExample callableExample = new CallableExample();
        FutureTask<Integer> task = new FutureTask<>(callableExample);
        Thread threadCallable = new Thread(task);
        threadCallable.setName("Example 3 - Callable: ");
        threadCallable.start();
        threadCallable.join();
        int result = task.get();
        System.out.println("RESULT: " + result);

//5. Запустить программу несколько раз - возможно, вернувшееся значение переменной, которую получит поток будет разным.
// Результатом программы прикрепить либо к решению, либо в коде комментарием следующие варианты:
//
//5.1. Какой диапазон результатов переменной возвращает поток после выполнения если программу запустить несколько раз?
// (пример 3000-3000);

//        Ответ:
//        результаты:
//        - 2799;
//        - 3001;
//        - 3001;
//        - 3001;
//        - 2432;
//        - 3001;
//        - 2562;

//
//5.2. Какой диапазон результатов переменной возвращает поток после выполнения если предварительно методу
// дополнительного класса, который вызывают все потоки добавить синхронизацию и запустить программу несколько раз?
// (пример 2980-3000);

//        Ответ:
//        результаты:
//        - 1837;
//        - 3001;
//        - 2194;
//        - 2769;
//
//5.3. Какой диапазон результатов переменной возвращает поток после выполнения если после КАЖДОГО запуска потока
// (start()) указывать остальным, чтобы ждали его выполнения (join()) и программу запустить несколько раз?
// (пример 2500-2900);

//        Ответ:
//        результаты:
//        - 3001;


//    Пример своего Deadlock-а;

        User user = new User();
        Admin admin = new Admin();

        user.setAdmin(admin);
        admin.setUser(user);



        Thread userThread = new Thread(() -> System.out.println(User.getValueFromAdmin()));
        Thread adminThread = new Thread(() -> System.out.println(Admin.getValueFromUser()));

        userThread.start();
        adminThread.start();


    }
}
