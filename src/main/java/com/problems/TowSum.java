package com.problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 * <p>
 * <p>
 * Constraints:
 * <p>2 <= nums.length <= 104
 * <p>-109 <= nums[i] <= 109
 * <p>-109 <= target <= 109
 * <p>Only one valid answer exists.
 */
public class TowSum {

    // O(n^2)
    public int[] findPair_BruteForce(int[] nums, int target) {

        // initialize result array
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            // assume nums[i] is one of the element of result
            // calculate value of second element
            int newTarget = target - nums[i];

            boolean isFound = false;
            // iterate over the array from current index + 1
            for (int j = i + 1; j < nums.length; j++) {
                if (newTarget == nums[j]) {
                    // assign result elements
                    result[0] = i;
                    result[1] = j;

                    // update isFound value to true
                    isFound = true;

                    // no need to iterate further
                    // as there is exact one pair
                    break;

                }
            }

            // if pair found
            // break the iteration
            if (isFound)
                break;
        }

        return result;
    }


    // O(n)
    public int[] findPair_HashMap(int[] nums, int target) {

        // initialize result array
        int[] result = new int[2];

        HashMap<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(nums[0], 0);

        for (int i = 1; i < nums.length; i++) {

            // assume nums[i] is one of the element of result
            // calculate value of second element
            int newTarget = target - nums[i];

            if (indexMap.containsKey(newTarget)) {
                // assign result elements
                result[0] = i;
                result[1] = indexMap.get(newTarget);
                break;
            } else {
                indexMap.put(nums[i], i);
            }
        }

        return result;
    }
}
