package homework21.threads;

import homework21.utils.ThreadHelper;

public class RunnableExample implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            ThreadHelper.threadHelper(Thread.currentThread());
        }

    }
}
