package com.problems;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 *
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m<p>
 * nums2.length == n<p>
 * 0 <= m <= 1000<p>
 * 0 <= n <= 1000<p>
 * 1 <= m + n <= 2000<p>
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class Medianof2SortedArrays {

    // bruteforce approach will have complexity of O(M+N)
    // create single array from the given two array - use merge sort's merge logic
    // calculate median of the new array
    public double findMedianSortedArrays(Integer[] nums1, Integer[] nums2) {
        // merged array initialization
        int[] merged = new int[nums1.length + nums2.length];


        int num1_counter = 0;
        int num2_counter = 0;
        int merged_counter = 0;
        // iterate over the both the array

        while (num1_counter < nums1.length && num2_counter < nums2.length) {

            // current element of num1 array is smaller or equals
            // assign that element to merged[currentIndex]
            if (nums1[num1_counter] <= nums2[num2_counter]) {
                merged[merged_counter] = nums1[num1_counter];

                // increment index of num1 array
                num1_counter++;
            } else {
                merged[merged_counter] = nums2[num2_counter];

                // increment index of num2 array
                num2_counter++;
            }

            // increment index of merged array
            merged_counter++;
        }

        // assign remaining element of
        // num1 to merged array
        while (num1_counter < nums1.length) {
            merged[merged_counter] = nums1[num1_counter];

            num1_counter++;
            merged_counter++;
        }

        // assign remaining element of
        // num2 to merged array
        while (num2_counter < nums2.length) {
            merged[merged_counter] = nums2[num2_counter];

            num2_counter++;
            merged_counter++;
        }


        int mergedArray_Length = merged.length;
        Double median;
        // find out median of merged array
        // required type casting as all elements
        // in integer only
        if (mergedArray_Length % 2 == 0) {

            // if array length is even then median will be
            // devide sum of middle 2 elements with 2
            median = Double.valueOf((merged[(mergedArray_Length / 2)] + merged[(mergedArray_Length / 2) - 1]) / 2);
        } else {

            // if array length is odd then median will be
            // middle element of array
            median = Double.valueOf(merged[mergedArray_Length / 2]);
        }
        return median;
    }

    // median is middle of array
    // 
    public double findMedianSortedArrays_approach2(Integer[] nums1, Integer[] nums2) {
        return calculateMedian(nums1, nums2, nums1.length, nums2.length);
    }


    public Double calculateMedian(Integer[] arr1, Integer[] arr2, int length1, int length2) {

        // if arr2's length is less then
        if (length1 > length2)
            return calculateMedian(arr2, arr1, length2, length1);

        int l = 0;
        int h = length1;

        // middle of merged array
        int middle = (length1 + length2 + 1) / 2;

        while (l <= h) {
            // middle of arr1
            int middle1 = (l + h) / 2;
            //  calculate middle of arr2
            int middle2 = middle - middle1;

            // if l == 0
            // assign Min value to l
            // or element at index middle-1
            int l1 = (middle1 == 0) ? Integer.MIN_VALUE : arr1[middle1 - 1];
            int l2 = (middle2 == 0) ? Integer.MIN_VALUE : arr2[middle2 - 1];

            // if r == length of arr
            // assign Max value to l
            // or element at index middle
            int r1 = (middle1 == length1) ? Integer.MAX_VALUE : arr1[middle1];
            int r2 = (middle2 == length2) ? Integer.MAX_VALUE : arr2[middle2];

            if (l1 <= r2 && l2 <= r1) {
                // found the right half of final array

                // if final array length is odd
                if ((length1 + length2) % 2 == 0) {
                    return Double.valueOf(Math.max(l1, l2));
                } else {
                    // if final array length is even
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
            } else if (l2 > r1) {
                l = middle1 + 1;
            } else {
                h = middle1 - 1;
            }
        }
        return 0.0;
    }

}
