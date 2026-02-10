package creatingThreads;

public class ExtendsThreadDemo {
    public static void main(String[] args) {
       Thread  t1 = new ThreadOne();
        Thread t2 = new ThreadTwo();

        t1.start();
        t2.start();

    }
}


class ThreadOne extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("ThreadOne is running");
        }
    }
}


class ThreadTwo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadTwo is running");
        }
    }
}