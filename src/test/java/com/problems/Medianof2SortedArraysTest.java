package com.problems;

import com.problems.dtos.GeneralTestCaseTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

class Medianof2SortedArraysTest {

    Medianof2SortedArrays medianof2SortedArrays;

    @BeforeEach
    void setUp() {
        this.medianof2SortedArrays = new Medianof2SortedArrays();
    }


    @ParameterizedTest
    @MethodSource("testCases")
    void findMedianSortedArrays_BruteForce(GeneralTestCaseTemplate generalTestCaseTemplate) {
        Integer[] arr1 = (Integer[]) generalTestCaseTemplate.getArr1();
        Integer[] arr2 = (Integer[]) generalTestCaseTemplate.getArr2();
        double actualMedian = this.medianof2SortedArrays.findMedianSortedArrays(arr1, arr2);
        Assertions.assertEquals(generalTestCaseTemplate.getResult(), actualMedian);
    }


    @ParameterizedTest
    @MethodSource("testCases")
    void findMedianSortedArrays_Approach2(GeneralTestCaseTemplate generalTestCaseTemplate) {
        Integer[] arr1 = (Integer[]) generalTestCaseTemplate.getArr1();
        Integer[] arr2 = (Integer[]) generalTestCaseTemplate.getArr2();
        double actualMedian = this.medianof2SortedArrays.findMedianSortedArrays(arr1, arr2);
        Assertions.assertEquals(generalTestCaseTemplate.getResult(), actualMedian);
    }


    /**
     * test cases
     *
     * @return
     */
    public static List<GeneralTestCaseTemplate> testCases() {
        return Arrays.asList(
                new GeneralTestCaseTemplate<Integer, Double>().withArr1(new Integer[]{1, 3, 5})
                        .withArr2(new Integer[]{1, 3, 5})
                        .withResult(Double.valueOf(3)),
                new GeneralTestCaseTemplate<Integer, Double>().withArr1(new Integer[]{1, 5, 9, 10})
                        .withArr2(new Integer[]{1, 3, 5})
                        .withResult(Double.valueOf(5)),
                new GeneralTestCaseTemplate<Integer, Double>().withArr1(new Integer[]{1, 2, 3})
                        .withArr2(new Integer[]{4, 5})
                        .withResult(Double.valueOf(3))
        );
    }
}
