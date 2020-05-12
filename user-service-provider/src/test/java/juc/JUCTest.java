package juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class JUCTest {
    private static final String name="00";
    private static AtomicInteger sum = new AtomicInteger(0);
    public static long sumL = 0;
    public static void main(String[] args) {

    }

    private static void test04() {
        CountDownLatch countDownlatch = new CountDownLatch(10);
        Thread t1 = null;
        for(int i=0;i<10;i++){
            new Thread(){
                @Override
                public void run() {
                   for (int i=0;i<10000;i++){
                       sumL++;
                       sum.incrementAndGet();
                   }
                    System.err.println("XXXX");
                }
            }.start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println(sumL);
        System.err.println(sum.get());
//        for(int i=0;i<10;i++){
//            t1 = new Thread(new Thread003(countDownlatch,sum,sumL));
//            t1.start();
//        }
//        try {
//            countDownlatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.err.println(sum.get());
//        System.err.println(sum.incrementAndGet());
    }

    public static class Thread003 implements Runnable{
        AtomicInteger sum;
        CountDownLatch countDownLatch;
        Long sumL;
        public Thread003(CountDownLatch countDownLatch,AtomicInteger sum,Long sumL){
            this.countDownLatch = countDownLatch;
            this.sum = sum;
            this.sumL = sumL;
        }
        @Override
        public void run() {
            for(int i=0;i<100;i++){
                int temi = sum.decrementAndGet();
                sumL--;
//                System.err.println(sumL);
                //System.err.println(temi);
            }
            countDownLatch.countDown();
        }
    }

    private static void Test003() {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        Thread t1 = null;
        for(int i=0;i<10;i++){
            t1 = new Thread01(countDownLatch,"张三"+i);
            t1.start();
        }

        t1 = new Thread02(countDownLatch,"减数线程1XX");
        t1.start();

        t1 = new Thread02(countDownLatch,"减数线程2XX");
        t1.start();
    }

    static class Thread01 extends Thread{
        CountDownLatch countDownLatch;
        String name;
        public Thread01(CountDownLatch countDownLatch,String name){
            super(name);
            this.countDownLatch = countDownLatch;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(Thread.currentThread().getName());
        }
    }

    static class Thread02 extends Thread{

        CountDownLatch countDownLatch;
        String name;
        public Thread02(CountDownLatch countDownLatch,String name){
            super(name);
            this.countDownLatch = countDownLatch;
            this.name = name;
        }

        @Override
        public void run() {
            for(int i=0;i<3;i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Long count = countDownLatch.getCount();
                countDownLatch.countDown();
                System.err.println(Thread.currentThread().getName()+",count=="+count);
            }
        }
    }

    private static void Test002() {
        String a = new String("hello");
        String b = new String("hello");
        char[] c = {'h','e','l','l','o'};
        System.err.println("a eq b :"+a.equals(b));
        System.err.println("a==b :" + (a==b));
        System.err.println(c.equals(a));
        System.err.println(a.equals(c));
    }

    public static class Test001{

        double setAtomicInteger(int i,int j){
            double result = 0;
            System.err.println(",finally 前");
            try {
                result = j/i;
                Thread.sleep(1000);
                return result;
            }catch (Exception e){
                System.err.println(",Exception！！！");
            }finally {
                System.err.println(",finally 被执行啦！！！");
                //return result;
            }
            System.err.println(",finally 后");
            return result;
        }

    }
}

