package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/4
 * @desp:
 */
public class QuickSort2 implements Sort {

    @Override
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            sort(arr, left, pivot - 1);
            sort(arr, pivot + 1, right);
        }
    }

    private int partition(int[] arr, int left, int right) {
        // 该行可有可无，有的话就是选 left 位置为中心，无的话就是选 right 位置为中心
        swap(arr, left, right);
        int pivot = left;
        for (int idx = left; idx < right; idx++) {
            if (arr[idx] < arr[right]) {
                swap(arr, pivot++, idx);
            }
        }
        swap(arr, pivot, right);
        return pivot;
    }

}
