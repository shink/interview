package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/4
 * @desp:
 */
public class QuickSort2 implements Sort {

    @Override
    public void sort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = partition(nums, left, right);
            sort(nums, left, pivot - 1);
            sort(nums, pivot + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        // 该行可有可无，有的话就是选 left 位置为中心，无的话就是选 right 位置为中心
        swap(nums, left, right);
        int pivot = left;
        for (int idx = left; idx < right; idx++) {
            if (nums[idx] < nums[right]) {
                swap(nums, pivot++, idx);
            }
        }
        swap(nums, pivot, right);
        return pivot;
    }

}
