package cc.janker.javaIntensively.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhiyongliu3 on 2017/7/20.
 */
public class ThreadTest {
    static volatile Integer t= 0;
    static Lock lock = new ReentrantLock();
    public static void main(String[] args) throws InterruptedException {
        ExecutorService th = Executors.newCachedThreadPool();
        long startTime = System.currentTimeMillis();
        for(int i = 0;i<10000;i++){
            th.execute(new Runnable() {
                public void run() {
                    synchronized (Integer.class) {
                        t++;
                    }
//                    lock.lock();
//
//                    lock.unlock();

                }
            });
        }
        th.shutdown();
        while(!th.isTerminated()){
        }

        System.out.println(System.currentTimeMillis()- startTime);

        System.out.println(t);
    }
}
