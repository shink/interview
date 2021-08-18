package com.yuanhaoji.interview.sort;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author: shenke
 * @project: interview
 * @date: 2021/8/9
 * @desp:
 */
public class HeapSortTest {

    @Test
    public void sort() {
        SortTestUtil.assertArrayEquals(new HeapSort());
    }
}