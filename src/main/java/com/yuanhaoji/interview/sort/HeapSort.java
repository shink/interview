package com.yuanhaoji.interview.sort;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/9
 * @desp:
 */
public class HeapSort implements Sort {

    @Override
    public void sort(int[] nums, int left, int right) {
        // 构建大顶堆，将待排序序列构建成一个大顶堆结构的数组
        build(nums, left, right);

        // 交换堆顶和当前末尾的节点，重置大顶堆
        for (int i = right; i > left; i--) {
            swap(nums, left, i);
            heapify(nums, left, i);
        }
    }

    private void build(int[] nums, int left, int right) {
        // 从最后一个非叶节点开始向前遍历，调整节点性质，使之成为大顶堆
        int length = right - left + 1;
        for (int i = (length >> 1) - 1; i >= 0; i--) {
            heapify(nums, left + i, right);
        }
    }

    private void heapify(int[] nums, int idx, int right) {
        // 先根据堆性质，找出它左右节点的索引
        int l = (idx << 1) + 1;
        int r = (idx << 1) + 2;
        // 默认当前节点（父节点）是最大值
        int largestIdx = idx;
        if (l <= right && nums[l] > nums[largestIdx]) {
            // 如果有左节点，并且左节点的值更大，更新最大值的索引
            largestIdx = l;
        }
        if (r <= right && nums[r] > nums[largestIdx]) {
            // 如果有右节点，并且右节点的值更大，更新最大值的索引
            largestIdx = r;
        }

        if (largestIdx != idx) {
            // 如果最大值不是当前非叶子节点的值，那么就把当前节点和最大值的子节点值互换
            swap(nums, idx, largestIdx);
            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整
            heapify(nums, largestIdx, right);
        }
    }

}
