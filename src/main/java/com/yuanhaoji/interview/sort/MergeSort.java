package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: Interview
 * @date: 2021/4/27
 * @desp:
 */
public class MergeSort implements Sort {

    @Override
    public void sort(int[] array, int left, int right) {
        // 开辟一个临时数组，避免在递归中频繁开辟空间
        int[] result = new int[array.length];
        mergeSort(array, left, right, result);
    }

    public void mergeSort(int[] array, int left, int right, int[] result) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, result);
            mergeSort(array, mid + 1, right, result);

            // 将两个子问题序列合并
            merge(array, left, mid, right, result);
        }
    }

    private void merge(int[] array, int left, int mid, int right, int[] result) {
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (array[i] >= array[j]) {
                result[k++] = array[j++];
            } else {
                result[k++] = array[i++];
            }
        }

        // 将剩余的左子问题序列填充到 result 中
        while (i <= mid) {
            result[k++] = array[i++];
        }

        // 将剩余的右子问题序列填充到 result 中
        while (j <= right) {
            result[k++] = array[j++];
        }

        // 将 result 中元素填充到原序列中，以便继续排序
        System.arraycopy(result, 0, array, left, right - left + 1);
    }

}
