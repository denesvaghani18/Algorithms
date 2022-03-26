package com.problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class TowSumTest {

    TowSum towSum;

    @BeforeEach
    void setUp() {
        this.towSum = new TowSum();
    }

    @ParameterizedTest(name = "{index} - {arguments}")
    @MethodSource("testCases")
    public void pairFound_Approach1_Test(TestCase testCase) {

        int[] result = towSum.findPair_BruteForce(testCase.getArr(), testCase.getTarget());
        Assertions.assertEquals(testCase.getResult()[0], result[0]);
        Assertions.assertEquals(testCase.getResult()[1], result[1]);
    }

    @ParameterizedTest(name = "{index} - {arguments}")
    @MethodSource("testCases")
    public void pairFound_Approach2_Test(TestCase testCase) {

        int[] result = towSum.findPair_HashMap(testCase.getArr(), testCase.getTarget());

        Assertions.assertEquals(testCase.getResult()[0], result[1]);
        Assertions.assertEquals(testCase.getResult()[1], result[0]);
    }

    public static List<TestCase> testCases() {
        return Arrays.asList(
                new TestCase(new int[]{1, 4, 3, 2, 5}, 9, new int[]{1, 4}),
                new TestCase(new int[]{-1, 4, 3, 1, 5}, 5, new int[]{1, 3}),
                new TestCase(new int[]{-1, 3, 4, 8, 2, 5}, 6, new int[]{2, 4}),
                new TestCase(new int[]{1, -3, -7, 3, 2, 5}, -10, new int[]{1, 2}),
                new TestCase(new int[]{0, 3, 4, 9, 2, 6}, 9, new int[]{0, 3})
        );
    }

}

class TestCase {
    private int[] arr;
    private int target;
    private int[] result;

    public TestCase() {
    }

    public TestCase(int[] arr, int target, int[] result) {
        this.arr = arr;
        this.target = target;
        this.result = result;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public int[] getResult() {
        return result;
    }

    public void setResult(int[] result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "arr=" + Arrays.toString(arr) +
                ", target=" + target +
                ", result=" + Arrays.toString(result) +
                '}';
    }
}
