package Synchronize;

public class LockWithCustomObjects {
    private static int counter1 = 0;
    private static int counter2 = 0;

    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            for(int i=0;i<10000;i++){
                increate1();
            }
        });

        Thread t2 = new Thread(() ->{
            for(int i=0;i<10000;i++){
                increate2();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Thread one counter: "+ counter1);
        System.out.println("Thread two counter: "+ counter2);
    }

    private static  void increate1(){
        synchronized(lock1){
            counter1++;

        }
    }

    private static  void increate2(){
        synchronized(lock2){
            counter2++;

        }
    }
}
