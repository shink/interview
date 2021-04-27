package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: Interview
 * @date: 2021/4/27
 * @desp:
 */
public class WhiteBoard {

    /**
     * 快速排序
     */
    public void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int i = left, j = right, pivot = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                --j;
            }
            while (i < j && arr[i] <= pivot) {
                ++i;
            }
            if (i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        arr[left] = arr[i];
        arr[i] = pivot;

        quickSort(arr, left, i - 1);
        quickSort(arr, i + 1, right);
    }

    /**
     * 归并排序
     */
    public void mergeSort(int[] arr, int left, int right) {
        int[] result = new int[arr.length];
        mergeSort(arr, left, right, result);
    }

    public void mergeSort(int[] arr, int left, int right, int[] result) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, result);
            mergeSort(arr, mid + 1, right, result);
            merge(arr, left, mid, right, result);
        }
    }

    private void merge(int[] arr, int left, int mid, int right, int[] result) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                result[k++] = arr[i++];
            } else {
                result[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            result[k++] = arr[i++];
        }
        while (j <= right) {
            result[k++] = arr[j++];
        }
        System.arraycopy(result, 0, arr, left, right - left + 1);
    }

}
