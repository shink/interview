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

public class QuickSortTest {

    @Test
    public void sort() {
        SortTestUtil.assertArrayEquals(new QuickSort());
    }
}