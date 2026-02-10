package creatingThreads;

public class JoinThreadDemo  {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Method Start...");
        Thread one = new Thread(() ->{
            for(long i = 0; i < 5; i++) {
                System.out.println("thread one"+i);
            }
        });

        Thread two = new Thread(() ->{
            for(long i = 0; i < 5; i++) {
                System.out.println("thread two"+i);
            }
        });

        one.start();
        one.join();
        two.start();


        System.out.println("Main Method finished");

    }
}
