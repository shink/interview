package com.yuanhaoji.interview.thread;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/16
 * @desp:
 */
public class Print {

    static class MyThread implements Runnable {
        private final int start;
        private final int end;
        private final int delta;

        public MyThread(int start, int end, int delta) {
            this.start = start;
            this.end = end;
            this.delta = delta;
        }

        @Override
        public void run() {
            synchronized (MyThread.class) {
                for (int i = start; i <= end; i += delta) {
                    System.out.println(i);
                    MyThread.class.notifyAll();
                    try {
                        MyThread.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 2, end = 100;
        for (int i = 0; i < threadNum; i++) {
            Thread thread = new Thread(new MyThread(i, end, threadNum));
            thread.start();
        }
    }

}
