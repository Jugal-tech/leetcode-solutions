import java.util.*;

/**
 * 🔹 Problem: Contains Duplicate
 * 🔹 Link: https://leetcode.com/problems/contains-duplicate/
 * 🔹 Platform: LeetCode
 * 🔹 Category: Arrays, Hashing
 * 
 * 🔹 Problem Statement:
 * Given an integer array nums, return true if any value appears at least twice 
 * in the array, and return false if every element is distinct.
 * 
 * ------------------------------------------------------------
 * 🔹 Approaches Implemented:
 * 
 * 1. HashMap (Frequency Check)
 * 2. HashSet (Optimal Solution)
 * 3. Sorting Approach
 * ------------------------------------------------------------
 */

public class Solution {

    /**
     * 🔹 Approach 1: HashMap (Frequency Check)
     * 
     * Algorithm:
     * - Store elements as keys in HashMap
     * - If key already exists → duplicate found
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean containsDuplicate_HashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, 1);
            }
        }
        return false;
    }


    /**
     * 🔹 Approach 2: HashSet (Optimal Solution)
     * 
     * Algorithm:
     * - Add elements into HashSet
     * - If element already exists → duplicate found
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public boolean containsDuplicate_HashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }


    /**
     * 🔹 Approach 3: Sorting
     * 
     * Algorithm:
     * - Sort the array
     * - Check adjacent elements for duplicates
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (ignoring sorting space)
     */
    public boolean containsDuplicate_Sorting(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
