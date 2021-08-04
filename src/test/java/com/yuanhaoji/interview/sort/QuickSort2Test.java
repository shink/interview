package com.yuanhaoji.interview.sort;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Test;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/4
 * @desp:
 */
public class QuickSort2Test {

    @Test
    public void sort() {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        new QuickSort2().sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}