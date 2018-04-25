package com.future;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestFuture {

    @Test
    public void test() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("开始");
        System.out.println("开始");
        System.out.println("开始");
        System.out.println("开始");

        Callable callable1 = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                return "call able1 string";
            }
        };
        Callable callable2 = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);

                Map<String, Object> map = new HashMap<String, Object>();

                map.put("aaa", "aaa");
                map.put("bbb", "bbb");
                map.put("ccc", "ccc");

                return map;
            }
        };

        FutureTask futureTask1 = new FutureTask(callable1);
        FutureTask futureTask2 = new FutureTask(callable2);

        new Thread(futureTask1).start();
        new Thread(futureTask2).start();


        try {
            String res1 = (String) futureTask1.get();
            Map<String, Object> res2 = (Map<String, Object>) futureTask2.get();

            System.out.println("输出结果1：" + res1);
            System.out.println("输出结果2：" + res2);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
