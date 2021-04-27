package com.yuanhaoji.interview.sort;

import java.util.Arrays;

/**
 * @author: shenke
 * @project: Interview
 * @date: 2021/4/27
 * @desp:
 */
public class QuickSort implements Sort {

    @Override
    public void sort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int i = left, j = right, pivot = arr[left];
        while (i < j) {
            // 先看右边，依次往左递减
            while (i < j && pivot <= arr[j]) {
                --j;
            }
            // 再看左边，依次往右递增
            while (i < j && pivot >= arr[i]) {
                ++i;
            }
            // 如果满足条件则交换
            if (i < j) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        // 最后将基准为与 i 和 j 相等位置的数字交换
        arr[left] = arr[i];
        arr[i] = pivot;

        // 递归调用左半数组
        sort(arr, left, j - 1);
        // 递归调用右半数组
        sort(arr, j + 1, right);
    }

}
