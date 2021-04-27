package com.yuanhaoji.interview.sort;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author: shenke
 * @project: Interview
 * @date: 2021/4/27
 * @desp:
 */

public class MergeSortTest {

    @Test
    public void sort() {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        new MergeSort().sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}