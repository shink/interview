package com.yuanhaoji.interview.sort;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/18
 * @desp:
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] nums, int left, int right) {
        for (int i = left; i < right; i++) {
            // 设定一个标记，若为 true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成
            boolean flag = true;

            for (int j = left; j < right - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
    }

}
