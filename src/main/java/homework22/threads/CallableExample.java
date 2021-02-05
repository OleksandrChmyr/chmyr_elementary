package homework22.threads;

import homework22.utils.LockExample;

import java.util.concurrent.Callable;

import static homework22.utils.LockExample.lockExample;

public class CallableExample implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        for (int i = 0; i < 3; i++) {
            LockExample lockExam = lockExample;
            lockExam.incrementMethod(Thread.currentThread());
            lockExam.sumMethod(Thread.currentThread());
            lockExam.doubleMethod(Thread.currentThread());
        }
        return LockExample.gInt.get();
    }
}
