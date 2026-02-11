package Synchronise;

public class SynchroniseDemo {

    private static int counter = 0;
    public static void main(String[] args) {

        Thread one = new Thread(() ->{
            for(int i=0;i<10000;i++){
                avoidRaceCondition();
            }
        });

        Thread two = new Thread(() ->{
            for(int i=0;i<10000;i++){
                avoidRaceCondition();
            }
        });

        one.start();
        two.start();
        try{
            one.join();
            two.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Thread Counter==>"+ counter);
    }

    private synchronized static void avoidRaceCondition(){
         counter++;
    }
}
/*
* This behavior is hapening due to unkown atomic operation
* */