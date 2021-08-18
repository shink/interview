package com.yuanhaoji.interview.thread;

import java.util.Stack;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/16
 * @desp:
 */
public class Singleton {

    public static volatile Singleton object = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (object == null) {
            synchronized (Singleton.class) {
                if (object == null) {
                    object = new Singleton();
                }
            }
        }
        return object;
    }

}
