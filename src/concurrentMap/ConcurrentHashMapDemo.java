package concurrentMap;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentHashMapDemo {

    private static final int noOfThreads = 5;
    private static final int noOfInsertions = 100;


    private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        try (ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads)) {
            for (int i = 0; i < noOfThreads; i++) {
                executorService.execute(insertData());
            }

            executorService.shutdown();

            if (executorService.isTerminated()) {
                Thread.sleep(1000);
            }
        }

        System.out.println("size of hashmap: " + map.size());

    }


    public static Runnable insertData(){
        return () -> {
            for (int i = 1; i <= noOfInsertions; i++) {
                map.put(i +Thread.currentThread().getName(), i);
            }
        };
    }
}
