package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: Interview
 * @date: 2021/4/27
 * @desp:
 */
public class QuickSort1 implements Sort {

    @Override
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            // 枢轴
            int pivot = partition(arr, left, right);
            sort(arr, left, pivot - 1);
            sort(arr, pivot + 1, right);
        }
    }

    public int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && array[i] <= array[j]) {
                --j;
            }
            if (i < j) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                ++i;
            }

            while (i < j && array[i] <= array[j]) {
                ++i;
            }
            if (i < j) {
                int tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }

        return i;
    }

}
