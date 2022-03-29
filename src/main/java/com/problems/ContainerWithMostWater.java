package com.problems;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * <p>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * <p>
 * Return the maximum amount of water a container can store.
 * <p>
 * Notice that you may not slant the container.
 *
 * <p><p>
 * Constraints:
 * <p>
 * n == height.length<p>
 * 2 <= n <= 105<p>
 * 0 <= height[i] <= 104
 */
public class ContainerWithMostWater {

    // take 2 pointer
    // increment 2nd pointer
    // current_area = calculate area
    // if max_area is less than current_area
    // then max_area = current_area

    // O(n^2)
    public int maxArea_bruteforce(Integer[] height) {

        // initialize max area
        int maxArea = Integer.MIN_VALUE;

        for(int i = 0; i < height.length; i++){
            for (int j = i+1; j < height.length; j++) {

                // min(ith ele, jth ele) * (j-1)
                int currentArea = Integer.min(height[i], height[j]) * (j - i);

                maxArea = Integer.max(currentArea,maxArea);
            }
        }

        return maxArea;
    }

    // O(n)
    public int maxArea_slidingWindow(Integer[] height){

        // initialize max area
        int maxArea = Integer.MIN_VALUE;

        // initialize 2 counter for window
        int counter1  = 0;

        // initialize 2nd counter with last index of array
        // as we want to cover max area.
        int counter2 = height.length -1;

        // shrink window until
        // window size become zero
        while(counter1 < counter2){
            // length of container
            int heightOfContainer = Integer.min(height[counter1], height[counter2]);
            // width of container
            int widthOfContainer = counter2 - counter1;

            // area  = heightOfContainer * widthOfContainer
            int currentArea = heightOfContainer * widthOfContainer;

            // compare with maxArea
            // if current area is more than max area
            // assign current area to max area
            maxArea = Integer.max(currentArea,maxArea);

            // shrink window
            // shrink towards maximum height
            // shrink counter1 if both has same height
            if(heightOfContainer == height[ counter1]){
                counter1++;
            }else{
                counter2--;
            }

        }

        // return max area
        return maxArea;
    }

}
