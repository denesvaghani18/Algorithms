package com.problems.dtos;

import java.util.Arrays;
import java.util.Objects;

// TODO - update setter method for new field
public class GeneralTestCaseTemplate<T, R> {

    private T[] arr1;
    private T[] arr2;
    private T[][] arr1_2d;
    private T[][] arr2_2d;

    private R target1;
    private R[] result_arr;
    private R result;
    private R[][] result_2d;

    public T[] getArr1() {
        return arr1;
    }

    public GeneralTestCaseTemplate withArr1(T[] arr1) {
        this.arr1 = arr1;
        return this;
    }

    public T[] getArr2() {
        return arr2;
    }

    public GeneralTestCaseTemplate withArr2(T[] arr2) {
        this.arr2 = arr2;
        return this;
    }

    public T[][] getArr1_2d() {
        return arr1_2d;
    }

    public GeneralTestCaseTemplate withArr1_2d(T[][] arr1_2d) {
        this.arr1_2d = arr1_2d;
        return this;
    }

    public T[][] getArr2_2d() {
        return arr2_2d;
    }

    public GeneralTestCaseTemplate withArr2_2d(T[][] arr2_2d) {
        this.arr2_2d = arr2_2d;
        return this;
    }

    public R getTarget1() {
        return target1;
    }

    public GeneralTestCaseTemplate withTarget1(R target1) {
        this.target1 = target1;
        return this;
    }

    public R[] getResult_Arr() {
        return result_arr;
    }

    public GeneralTestCaseTemplate withResult_Arr(R[] result) {
        this.result_arr = result;
        return this;
    }

    public R[][] getResult_2d() {
        return result_2d;
    }

    public GeneralTestCaseTemplate withResult_2d(R[][] result_2d) {
        this.result_2d = result_2d;
        return this;
    }

    public R getResult() {
        return result;
    }

    public GeneralTestCaseTemplate withResult(R result) {
        this.result = result;
        return this;
    }
    // TODO - update toString() if new field is added

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder("GeneralTestCaseTemplate{");

        if (Objects.nonNull(arr1)) obj.append("arr1=" + Arrays.toString(arr1));
        if (Objects.nonNull(arr2)) obj.append(", arr2=" + Arrays.toString(arr2));
        if (Objects.nonNull(arr1_2d)) obj.append(", arr1_2d=" + Arrays.toString(arr1_2d));
        if (Objects.nonNull(arr2_2d)) obj.append(", arr2_2d=" + Arrays.toString(arr2_2d));
        if (Objects.nonNull(target1)) obj.append(", target1=" + target1);
        if (Objects.nonNull(result)) obj.append(", result=" + result);
        if (Objects.nonNull(result_arr)) obj.append(", result_arr=" + Arrays.toString(result_arr));
        if (Objects.nonNull(result_2d)) obj.append(", result_2d=" + Arrays.toString(result_2d));

        obj.append('}');
        return String.valueOf(obj);
    }
}
