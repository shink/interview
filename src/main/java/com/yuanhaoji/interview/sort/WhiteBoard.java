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
    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }

        int i = left, j = right, pivot = nums[left];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                --j;
            }
            while (i < j && nums[i] <= pivot) {
                ++i;
            }
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        nums[left] = nums[i];
        nums[i] = pivot;

        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
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

    private void merge(int[] nums, int left, int mid, int right, int[] result) {
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                result[k++] = nums[i++];
            } else {
                result[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            result[k++] = nums[i++];
        }
        while (j <= right) {
            result[k++] = nums[j++];
        }
        System.arraycopy(result, 0, nums, left, right - left + 1);
    }

}
