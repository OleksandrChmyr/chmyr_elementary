package homework22.threads;

import homework22.utils.LockExample;

import static homework22.utils.LockExample.lockExample;

public class ThreadExample extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            LockExample lockExam = lockExample;
            lockExam.incrementMethod(Thread.currentThread());
            lockExam.sumMethod(Thread.currentThread());
            lockExam.doubleMethod(Thread.currentThread());

        }
    }
}
