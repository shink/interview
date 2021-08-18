package com.yuanhaoji.interview.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/18
 * @desp:
 */
public class ProducerAndConsumer<T> {

    final private Queue<T> list = new LinkedList<>();
    final private int MAX = 10;

    public synchronized void put(T t) {
        while (list.size() == MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.offer(t);
        System.out.printf("%s 生产了 %s%n", Thread.currentThread().getName(), t);
        // 通知消费者线程进行消费
        this.notifyAll();
    }

    public synchronized T get() {
        T t;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.poll();
        System.out.printf("%s 消费了 %s%n", Thread.currentThread().getName(), t);
        // 通知生产者进行生产
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        ProducerAndConsumer<String> producerAndConsumer = new ProducerAndConsumer<>();

        // 启动消费者线程
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 4; j++) {
                    producerAndConsumer.get();
                }
            }, "consumer" + i).start();
        }

        try {
            System.out.println("等待 1 秒生产-开始");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("等待 1 秒生产-结束");
        }

        // 启动生产者线程
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 8; j++) {
                    producerAndConsumer.put(Thread.currentThread().getName() + " " + j);
                }
            }, "product" + i).start();
        }
    }

}
