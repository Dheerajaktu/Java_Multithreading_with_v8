package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadExecutorDemo {
    public static void main(String[] args) {
        try(ExecutorService executorService = Executors.newFixedThreadPool(2)){
            for(int i=0;i<10;i++){
                executorService.execute(new Worker(i));
                System.out.println("Fixed Executor Service=="+ Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


class Worker implements Runnable{

    private final int workId;
    public Worker(int workId) {
        this.workId = workId;
    }

    @Override
    public void run() {
        System.out.println("Work ID: "+workId +"==is being excute with thread==>>"+ Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}