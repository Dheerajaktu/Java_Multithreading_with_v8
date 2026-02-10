package creatingThreads;

public class ThreadPrioirty {
    public static void main(String[] args) {

        System.out.println("Main Thread Started: "+ Thread.currentThread().getName());

        System.out.println("Main Thread Default Priority: "+ Thread.currentThread().getPriority());


        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println("Main Thread Priority post update: "+ Thread.currentThread().getPriority());
    }
}
