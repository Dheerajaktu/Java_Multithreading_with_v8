package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CpuIntensiveTaskDemo {
    public static void main(String[] args) {
        int cpuCores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available cpuCores in my computer==="+cpuCores);
        ExecutorService executorService = Executors.newFixedThreadPool(cpuCores);
        for(int i=0;i<120;i++){
            executorService.execute(new CpuTask());
        }
    }
}


class CpuTask implements Runnable{
    @Override
    public void run() {
        System.out.println("CpuTask ===>>"+ Thread.currentThread().getName());
    }
}