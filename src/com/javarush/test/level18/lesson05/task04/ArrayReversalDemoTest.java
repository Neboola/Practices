package com.javarush.test.level18.lesson05.task04;

/**
 * Created by OmniTool on 23.01.2016.
 */
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayReversalDemoTest {
    @Test
    public void testReverseWithEvenLengthOfArray() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        Solution.reverse(numbers);
        assertArrayEquals(new int[]{6, 5, 4, 3, 2, 1}, numbers);
    }

    @Test
    public void testReverseWithOddLengthOfArray() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        Solution.reverse(numbers);
        assertArrayEquals(new int[]{7, 6, 5, 4, 3, 2, 1}, numbers);
    }

    @Test
    public void testReverseWithEmptyArray() {
        int[] numbers = {};
        Solution.reverse(numbers);
        assertArrayEquals(new int[]{}, numbers);
    }

    @Test
    public void testReverseWithNullArray() {
        int[] numbers = null;
        Solution.reverse(numbers);
        assertArrayEquals(null, numbers);
    }

    @Test
    public void testReverseWithJustOneElementArray() {
        int[] numbers = {1};
        Solution.reverse(numbers);
        assertArrayEquals(new int[]{1}, numbers);
    }
}