import java.util.*;

/**
 * 🔹 Problem: Move Zeroes
 * 🔹 Link: https://leetcode.com/problems/move-zeroes/
 * 🔹 Platform: LeetCode
 * 🔹 Category: Arrays, Two Pointers
 * 
 * 🔹 Problem Statement:
 * Given an integer array nums, move all 0's to the end of it while maintaining 
 * the relative order of the non-zero elements.
 * 
 * Note:
 * - You must do this in-place without making a copy of the array.
 * 
 * ------------------------------------------------------------
 * 🔹 Approaches Implemented:
 * 
 * 1. Brute Force (Extra Array)
 * 2. Two Pointer (Optimal)
 * 3. Snowball Approach
 * ------------------------------------------------------------
 */

public class Solution {

    /**
     * 🔹 Approach 1: Brute Force (Extra Array)
     * 
     * Algorithm:
     * - Create a new array
     * - First copy all non-zero elements
     * - Then fill remaining positions with zero
     * - Copy back to original array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public void moveZeroes_BruteForce(int[] nums) {
        int[] temp = new int[nums.length];
        int index = 0;

        // Add non-zero elements
        for (int num : nums) {
            if (num != 0) {
                temp[index++] = num;
            }
        }

        // Fill remaining with zero
        while (index < nums.length) {
            temp[index++] = 0;
        }

        // Copy back
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }


    /**
     * 🔹 Approach 2: Two Pointer (Optimal)
     * 
     * Algorithm:
     * - Use two pointers: start and end
     * - Traverse using end pointer
     * - If element is non-zero → swap with start
     * - Increment start
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void moveZeroes_TwoPointer(int[] nums) {
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            if (nums[end] != 0) {
                int temp = nums[end];
                nums[end] = nums[start];
                nums[start] = temp;
                start++;
            }
        }
    }


    /**
     * 🔹 Approach 3: Snowball Approach
     * 
     * Algorithm:
     * - Count number of zeros (snowball size)
     * - When non-zero element found → shift it left by snowball size
     * - Fill current position with zero
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public void moveZeroes_Snowball(int[] nums) {
        int snowball = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowball++;
            } else if (snowball > 0) {
                nums[i - snowball] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
