package SynchronisedConcurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerRestaurantDemo {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);

        //PRODUCER
        new Thread(() ->{
            for(int i=0;i<10;i++){
                // adding into queue
                String order = "Order Id: "+i;
                try {
                    System.out.println("Order Added into Queue==>> Order No: "+ i);
                    queue.put(order);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        // Consumer
        new Thread(() ->{
            while(true){
                try {
                    // consuming from queue
                    String order = queue.take(); // Will wait if queue is empty
                    System.out.println("Processing: " + order);
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}

/*
* Internally it manage followings -
* 1 - Locking  --> (ReentrantLock)
* 2 - wait()/notify()
* 3 - conditional variable
* */