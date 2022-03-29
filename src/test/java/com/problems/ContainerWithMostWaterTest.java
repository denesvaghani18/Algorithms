package com.problems;

import com.problems.dtos.GeneralTestCaseTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

class ContainerWithMostWaterTest {

    ContainerWithMostWater containerWithMostWater;

    @BeforeEach
    void setUp() {
        this.containerWithMostWater = new ContainerWithMostWater();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void maxArea_BruteForceTest(GeneralTestCaseTemplate generalTestCaseTemplate) {

        int maxArea = this.containerWithMostWater.maxArea_bruteforce((Integer[]) generalTestCaseTemplate.getArr1());
        Assertions.assertEquals(generalTestCaseTemplate.getResult(), maxArea);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    void maxArea_SlidingWindowTest(GeneralTestCaseTemplate generalTestCaseTemplate) {

        int maxArea = this.containerWithMostWater.maxArea_slidingWindow((Integer[]) generalTestCaseTemplate.getArr1());
        Assertions.assertEquals(generalTestCaseTemplate.getResult(), maxArea);
    }

    /**
     * test cases
     */
    private static List<GeneralTestCaseTemplate> testCases() {
        return Arrays.asList(
                new GeneralTestCaseTemplate<Integer, Integer>().withArr1(new Integer[]{1, 8, 6, 2, 5, 4, 8, 3, 7})
                        .withResult(49),
                new GeneralTestCaseTemplate<Integer, Integer>().withArr1(new Integer[]{1, 1})
                        .withResult(1),
                new GeneralTestCaseTemplate<Integer, Integer>().withArr1(new Integer[]{1, 1, 1, 1, 1, 1})
                        .withResult(5)
        );
    }
}