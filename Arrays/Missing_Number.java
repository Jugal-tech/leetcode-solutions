import java.util.*;

/**
 * 🔹 Problem: Missing Number
 * 🔹 Link: https://leetcode.com/problems/missing-number/
 * 🔹 Platform: LeetCode
 * 🔹 Category: Arrays, Math
 * 
 * 🔹 Problem Statement:
 * Given an array nums containing n distinct numbers in the range [0, n], 
 * return the only number in the range that is missing from the array.
 * 
 * ------------------------------------------------------------
 * 🔹 Approaches Implemented:
 * 
 * 1. Sum Formula (Your Approach)
 * 2. XOR Approach (Optimal)
 * 3. Sorting Approach
 * ------------------------------------------------------------
 */

public class Solution {

    /**
     * 🔹 Approach 1: Sum Formula (Math)
     * 
     * Algorithm:
     * - Calculate expected sum of numbers from 0 to n
     * - Calculate actual sum of array elements
     * - Missing number = difference of both sums
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int missingNumber_Sum(int[] nums) {
        int n = nums.length;
        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }


    /**
     * 🔹 Approach 2: XOR (Optimal)
     * 
     * Algorithm:
     * - XOR all numbers from 0 to n
     * - XOR all elements of array
     * - Final XOR gives missing number
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int missingNumber_XOR(int[] nums) {
        int xor = 0;
        int n = nums.length;

        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }

        for (int num : nums) {
            xor ^= num;
        }

        return xor;
    }


    /**
     * 🔹 Approach 3: Sorting
     * 
     * Algorithm:
     * - Sort the array
     * - Check index vs value mismatch
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public int missingNumber_Sorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
