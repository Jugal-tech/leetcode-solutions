import java.util.*;

/**
 * 🔹 Problem: Two Sum
 * 🔹 Link: https://leetcode.com/problems/two-sum/
 * 🔹 Platform: LeetCode
 * 🔹 Category: Arrays, Hashing
 * 
 * 🔹 Problem Statement:
 * Given an array of integers nums and an integer target, return indices of the 
 * two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution, and you may 
 * not use the same element twice.
 * 
 * ------------------------------------------------------------
 * 🔹 Approaches Implemented:
 * 
 * 1. Brute Force (Nested Loops)
 * 2. HashMap (Optimal Solution)
 * 3. Two Pointer (Sorting)
 * ------------------------------------------------------------
 */

public class Solution {

    /**
     * 🔹 Approach 1: Brute Force (Your Approach)
     * 
     * Algorithm:
     * - Use two loops to check every pair
     * - If sum equals target → return indices
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public int[] twoSum_BruteForce(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }


    /**
     * 🔹 Approach 2: HashMap (Optimal Solution)
     * 
     * Algorithm:
     * - Store number and its index in HashMap
     * - Check if (target - current) exists
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] twoSum_HashMap(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }


    /**
     * 🔹 Approach 3: Two Pointer (Sorting)
     * 
     * Algorithm:
     * - Store value + index pairs
     * - Sort array based on values
     * - Use two pointers to find target sum
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public int[] twoSum_TwoPointer(int[] nums, int target) {
        int n = nums.length;

        // store value + index
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        // sort based on values
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int left = 0, right = n - 1;

        while(left < right){
            int sum = arr[left][0] + arr[right][0];

            if(sum == target){
                return new int[]{arr[left][1], arr[right][1]};
            } 
            else if(sum < target){
                left++;
            } 
            else{
                right--;
            }
        }
        return new int[]{};
    }
}
