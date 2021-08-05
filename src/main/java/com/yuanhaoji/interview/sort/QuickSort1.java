package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: Interview
 * @date: 2021/4/27
 * @desp:
 */
public class QuickSort1 implements Sort {

    @Override
    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            // 枢轴
            int pivot = partition(nums, left, right);
            sort(nums, left, pivot - 1);
            sort(nums, pivot + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;

        while (i < j) {
            while (i < j && nums[i] <= nums[j]) {
                --j;
            }
            if (i < j) {
                swap(nums, i, j);
                ++i;
            }

            while (i < j && nums[i] <= nums[j]) {
                ++i;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }

        return i;
    }

}
