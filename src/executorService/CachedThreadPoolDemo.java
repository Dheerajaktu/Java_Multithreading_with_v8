package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolDemo {
    public static void main(String[] args) {

        try(ExecutorService executorService = Executors.newCachedThreadPool()){
            for(int i=0;i<1000;i++){
                executorService.execute(new Worker(i));
                System.out.println("Cache Executor Service=="+ Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


class WorkerCache implements Runnable{
    private final int workerId;
    public WorkerCache(int workerId){
        this.workerId = workerId;
    }


    @Override
    public void run() {
        System.out.println("Worker ID: "+workerId +"==is being excute with thread==>>"+ Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}