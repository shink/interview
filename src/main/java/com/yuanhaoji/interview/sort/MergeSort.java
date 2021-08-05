package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: Interview
 * @date: 2021/4/27
 * @desp:
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] nums, int left, int right) {
        // 开辟一个临时数组，避免在递归中频繁开辟空间
        int[] result = new int[nums.length];
        mergeSort(nums, left, right, result);
    }

    public void mergeSort(int[] nums, int left, int right, int[] result) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(nums, left, mid, result);
            mergeSort(nums, mid + 1, right, result);

            // 将两个子问题序列合并
            merge(nums, left, mid, right, result);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] result) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (nums[i] >= nums[j]) {
                result[k++] = nums[j++];
            } else {
                result[k++] = nums[i++];
            }
        }

        // 将剩余的左子问题序列填充到 result 中
        while (i <= mid) {
            result[k++] = nums[i++];
        }

        // 将剩余的右子问题序列填充到 result 中
        while (j <= right) {
            result[k++] = nums[j++];
        }

        // 将 result 中元素填充到原序列中，以便继续排序
        System.arraycopy(result, 0, nums, left, right - left + 1);
    }

}
