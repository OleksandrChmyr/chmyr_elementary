package homework22.utils;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    //2. Зная о таком подходе как Lock создать класс, у которого будет 3 метода (на Ваше усмотрение), которые должны
// выполняться последовательно и только одним потоком. После выполнения третьего Вашего метода давать возможность
// выполнение другим потокам этих методов. Запустить для проверки логики 3 потока.
    public static AtomicInteger gInt = new AtomicInteger(100);
    public static LockExample lockExample = new LockExample();
    private Lock lock = new ReentrantLock();

    public void incrementMethod(Thread thread) {
        lock.lock();
        System.out.println(thread.getName() + " - incrementMethod - " + gInt);
        gInt.incrementAndGet();
        gInt.get();

    }

    public void sumMethod(Thread thread) {
        System.out.println(thread.getName() + " - sumMethod - " + gInt);
        gInt.addAndGet(5);
        gInt.get();

    }

    public void doubleMethod(Thread thread) {
        System.out.println(thread.getName() + " - doubleMethod - " + gInt);
        gInt.doubleValue();
        gInt.get();
        lock.unlock();


    }
}
