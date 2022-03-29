package com.problems;

import com.problems.dtos.GeneralTestCaseTemplate;
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
    public void pairFound_Approach1_Test(GeneralTestCaseTemplate generalTestCaseTemplate) {
        Integer[] inputArray = (Integer[]) generalTestCaseTemplate.getArr1();
        int target = (int) generalTestCaseTemplate.getTarget1();
        int[] result = towSum.findPair_BruteForce(inputArray, target);

        Assertions.assertEquals(generalTestCaseTemplate.getResult_Arr()[0], result[0]);
        Assertions.assertEquals(generalTestCaseTemplate.getResult_Arr()[1], result[1]);
    }

    @ParameterizedTest(name = "{index} - {arguments}")
    @MethodSource("testCases")
    public void pairFound_Approach2_Test(GeneralTestCaseTemplate generalTestCaseTemplate) {
        Integer[] inputArray = (Integer[]) generalTestCaseTemplate.getArr1();
        int target = (int) generalTestCaseTemplate.getTarget1();
        int[] result = towSum.findPair_HashMap(inputArray, target);

        Assertions.assertEquals(generalTestCaseTemplate.getResult_Arr()[0], result[1]);
        Assertions.assertEquals(generalTestCaseTemplate.getResult_Arr()[1], result[0]);
    }

    /**
     * test cases
     *
     * @return
     */
    private static List<GeneralTestCaseTemplate> testCases() {
        return Arrays.asList(
                new GeneralTestCaseTemplate<Integer, Integer>().withArr1(new Integer[]{1, 4, 3, 2, 5})
                        .withTarget1(9)
                        .withResult(new Integer[]{1, 4}),
                new GeneralTestCaseTemplate<Integer, Integer>().withArr1(new Integer[]{-1, 4, 3, 1, 5})
                        .withTarget1(5)
                        .withResult(new Integer[]{1, 3}),
                new GeneralTestCaseTemplate<Integer, Integer>().withArr1(new Integer[]{-1, 3, 4, 8, 2, 5})
                        .withTarget1(6)
                        .withResult(new Integer[]{2, 4}),
                new GeneralTestCaseTemplate<Integer, Integer>().withArr1(new Integer[]{1, -3, -7, 3, 2, 5})
                        .withTarget1(-10)
                        .withResult(new Integer[]{1, 2}),
                new GeneralTestCaseTemplate<Integer, Integer>().withArr1(new Integer[]{0, 3, 4, 9, 2, 6})
                        .withTarget1(9)
                        .withResult(new Integer[]{0, 3})
        );
    }
}