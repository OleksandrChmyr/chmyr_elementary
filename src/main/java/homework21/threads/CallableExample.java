package homework21.threads;

import homework21.Utils.ThreadHelper;

import java.util.concurrent.Callable;

public class CallableExample implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {

        for (int i = 0; i < 1000; i++) {
            ThreadHelper.threadHelper(Thread.currentThread());
        }
        return ThreadHelper.j;
    }
}
