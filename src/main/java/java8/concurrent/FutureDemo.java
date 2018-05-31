package java8.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<?> future  = executorService.submit(()->{

            System.out.println("Hello,World");
        });
        
        int i=0;
        
        // 等待线程执行完毕
        while(!future.isDone()){
        	// System.out.println(++i);
        }
        
        System.out.println("执行完毕");

        executorService.shutdown();
    }

}
