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
        SortTestUtil.assertArrayEquals(new QuickSort2());
    }

}