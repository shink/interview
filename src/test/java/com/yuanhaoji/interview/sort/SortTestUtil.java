package com.yuanhaoji.interview.sort;

import java.util.Arrays;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/4
 * @desp:
 */

public class SortTestUtil {

    private static Logger logger = LoggerFactory.getLogger(SortTestUtil.class);

    public static void assertArrayEquals(Sort sort) {
        int n = 10;
        int[] nums = generateRandomNums(0, 10, n);
        // int[] nums = new int[] {1, 4, 4, 4, 4, 5, 5, 6, 7, 8};
        int[] origin = new int[n];
        System.arraycopy(nums, 0, origin, 0, n);

        Arrays.sort(origin);
        sort.sort(nums, 0, n - 1);
        logger.info("Expected: {}", Arrays.toString(origin));
        logger.info("Actual  : {}", Arrays.toString(nums));

        Assert.assertArrayEquals(origin, nums);
    }

    public static int[] generateRandomNums(int min, int max, int length) {
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = (int) Math.round(Math.random() * (max - min) + min);
        }
        return nums;
    }

}
