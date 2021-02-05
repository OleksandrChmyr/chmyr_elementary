package homework22;

import homework22.threads.CallableExample;
import homework22.threads.RunnableExample;
import homework22.threads.ThreadExample;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger integer = new AtomicInteger(100000);


    public static void main(String[] args) throws InterruptedException, ExecutionException {
//1. Создать 2 потока, внутри которых будет идентичная логика: Создание в цикле по 10000 потоков, которые будут
// выполнять декремент переменной. Обеспечить Атомарность/ Потокобезопасность всех операций и после выполнения всех
// потоков вывести результат (результат должен быть стабильным при нескольких запусках программы);

        Object o = new Object();
        Thread firstTread = new Thread(() -> {
            synchronized (o) {
                threadExOneMethod();
                o.notify();
            }
        });
        firstTread.start();
        firstTread.setName("First");
        synchronized (o) {
            o.wait();
        }
        System.out.println("\n -- First Tread ended -- \n");


        Thread secondTread = new Thread(() -> {
            synchronized (o) {
                threadExOneMethod();
                o.notify();
            }
        });
        secondTread.start();
        secondTread.setName("Second");
        synchronized (o) {
            o.wait();
        }
        System.out.println("\n -- Second Tread ended -- \n");
        System.out.println(" -- FINAL RESULT of Assignment 1: -- \n" + "Integer value = " + integer.get() + "\n");


//2. Зная о таком подходе как Lock создать класс, у которого будет 3 метода (на Ваше усмотрение), которые должны
// выполняться последовательно и только одним потоком. После выполнения третьего Вашего метода давать возможность
// выполнение другим потокам этих методов. Запустить для проверки логики 3 потока.
        ThreadExample threadExample = new ThreadExample();
        threadExample.setName("Thread: ");
        threadExample.start();

        RunnableExample runnableExample = new RunnableExample();
        Thread threadRunnable = new Thread(runnableExample);
        threadRunnable.setName("Runnable: ");
        threadRunnable.start();

        CallableExample callableExample = new CallableExample();
        FutureTask<Integer> task = new FutureTask<>(callableExample);
        Thread threadCallable = new Thread(task);
        threadCallable.setName("Callable: ");
        threadCallable.start();

        int result = task.get();
        System.out.println(" -- FINAL RESULT of Assignment 2: -- \n" + "Value = " + result);

    }

    private synchronized static void threadExOneMethod() {
        for (int i = 0; i < 10000; i++) {
            integer.decrementAndGet();
//            System.out.println(Thread.currentThread().getName() + " - " + integer.get());
        }
    }
}

