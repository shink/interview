package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: Interview
 * @date: 2021/4/27
 * @desp:
 */
public interface Sort {

    /**
     * 排序，[left, right]
     *
     * @param nums  数字数组
     * @param left  左边界
     * @param right 右边界
     */
    void sort(int[] nums, int left, int right);

    default void swap(int[] nums, int left, int right) {
        if (left != right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
        }
    }

}
