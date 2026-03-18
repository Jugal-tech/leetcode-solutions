import java.util.*;

/**
 * 🔹 Problem: Majority Element
 * 🔹 Link: https://leetcode.com/problems/majority-element/ 
 * 🔹 Platform: LeetCode
 * 🔹 Category: Arrays
 * 
 * 🔹 Problem Statement:
 * Given an array nums of size n, return the element that appears more than ⌊n/2⌋ times.
 * You may assume that the majority element always exists in the array.
 * 
 * ------------------------------------------------------------
 * 🔹 Approaches Implemented:
 * 
 * 1. Hashing (Frequency Count using HashMap)
 * 2. Moore’s Voting Algorithm (Optimal Solution)
 * 3. Sorting Approach
 * ------------------------------------------------------------
 */

public class Solution {

    /**
     * 🔹 Approach 1: Hashing (Frequency Count)
     * 
     * Algorithm:
     * - Count occurrences of each element using HashMap
     * - Return element whose frequency > n/2
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int majorityElement_Hashing(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>(); 
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        int n = nums.length / 2;

        Set<Integer> key = map.keySet();
        for(int k : key){
            if(map.get(k) > n){
                return k;
            }
        }
        return 0;
    }


    /**
     * 🔹 Approach 2: Moore’s Voting Algorithm (Optimal)
     * 
     * Algorithm:
     * - Maintain a candidate and a counter
     * - Cancel out different elements
     * - Final candidate is the majority element
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int majorityElement_MooreVoting(int[] nums) {
        int candidate = 0, count = 0;

        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
            }

            if(candidate == nums[i]){
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


    /**
     * 🔹 Approach 3: Sorting
     * 
     * Algorithm:
     * - Sort the array
     * - The middle element will always be the majority element
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (ignoring sorting space)
     */
    public int majorityElement_Sorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
