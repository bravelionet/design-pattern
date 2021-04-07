package com.bravelionet;

import java.util.concurrent.*;

public class FutureTaskTest {

    private static final int CPU_NUM = Runtime.getRuntime().availableProcessors();

     private final static ThreadPoolExecutor pool = new ThreadPoolExecutor(CPU_NUM, CPU_NUM * 2, 1,
          TimeUnit.MINUTES, new LinkedBlockingDeque<>(5), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());


    public static void main(String[] args) throws InterruptedException, ExecutionException {

        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                String name = Thread.currentThread().getName();
                System.out.println("当前线程名字 :  " + name);

                return "call() ...";
            }
        });
        System.out.println(" 执行前 ...");
        pool.execute(stringFutureTask);


        boolean startDone = stringFutureTask.isDone();
        System.out.println(" 任务执行是否完成 " + startDone);

        // 调用 get 方法会进行堵塞主线程,执行任务完成后才回继续向下执行
        // 等待异步计算任务完成,并返回结果,如果当前任务计算还没有完成则会进行阻塞调用线程,
        // 直到线程任务完成后,如果大在等待结果的过程中其他线程取消了该任务,则调用线程会爆出 CancellationException异常
        // 如果在等待结果过程中有线程中断了该线程,责护爆出 InterruptedException 异常,如果任务计算过程中出现异常,则会抛出 ExecutionException

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
