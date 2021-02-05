package homework22;

public class Main {

    private static Integer integer = 0;

    public static void main(String[] args) {


        Runnable first = () -> {
            Thread.currentThread().setName("FIRST");
            print();
        };

        Runnable second = () -> {
            Thread.currentThread().setName("second");
            print();
        };

        Thread threadFirst = new Thread(first);
        Thread threadSecond = new Thread(second);
        threadFirst.start();
        threadSecond.start();


    }
        private synchronized static void print() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(Thread.currentThread().getName() +". increment: " + integer++);
            }
        }
    }

