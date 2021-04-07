package com.bravelionet;

import java.util.concurrent.*;

public class FutureTaskTest2 {

    private static final int CPU_NUM = Runtime.getRuntime().availableProcessors();

     private final static ThreadPoolExecutor pool = new ThreadPoolExecutor(CPU_NUM, CPU_NUM * 2, 1,
          TimeUnit.MINUTES, new LinkedBlockingDeque<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws InterruptedException, ExecutionException {

       /* FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                String name = Thread.currentThread().getName();
                System.out.println("当前线程名字 :  " + name);

                return "call() ...";
            }
        });*/
        System.out.println(" 执行前 ...");
        // submit 和 execute 等价的
        Future<String> stringFutureTask = pool.submit(() -> {
            Thread.sleep(2000);
            String name = Thread.currentThread().getName();
            System.out.println("当前线程名字 :  " + name);

            return "call() ...";
        });


        boolean startDone = stringFutureTask.isDone();
        System.out.println(" 任务执行是否完成 " + startDone);

        // 调用 get 方法会进行堵塞主线程,执行任务完成后才回继续向下执行
        String s = stringFutureTask.get();

        boolean endDone = stringFutureTask.isDone();
        System.out.println(" 任务是否完成 " + endDone);
        System.out.println("s = " + s);

        System.out.println(" 执行后 ...");
        doTing2();

        pool.shutdown();
    }


    public static  FutureTask<String> doTing(){

        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String name = Thread.currentThread().getName();
                System.out.println("当前线程名字 :  " + name);

                return "call() ...";
            }
        });
        return stringFutureTask;

    }



    public static void doTing2() throws InterruptedException {

      //  Thread.sleep(2000);

        System.out.println(" doting2 :  " + CPU_NUM);

    }
}
