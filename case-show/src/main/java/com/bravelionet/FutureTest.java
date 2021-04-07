package com.bravelionet;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
    private static final int CPU_NUM = Runtime.getRuntime().availableProcessors();

    //  private final static ThreadPoolExecutor pool = new ThreadPoolExecutor(CPU_NUM, CPU_NUM * 2, 1,
    //      TimeUnit.MINUTES, new LinkedBlockingDeque<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    static ExecutorService pool = Executors.newCachedThreadPool();
    public static void main(String[] args) {

        System.out.println(" 之前执行  ");
        Future<String> submit = pool.submit(() -> doTing());
        System.out.println(" 之后执行 ");
        try {
            String future = submit.get();
            System.out.println(" 再次执行执行 ");
            String future1 = submit.get();
            System.out.println("future = " + future);
            System.out.println("future1 = " + future1);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        pool.shutdown();

    }


    public static String doTing() {

        try {
            String name = Thread.currentThread().getName();
            System.out.println("name = " + name);
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("CPU_NUM = " + CPU_NUM);
        return "lll";
    }
}
