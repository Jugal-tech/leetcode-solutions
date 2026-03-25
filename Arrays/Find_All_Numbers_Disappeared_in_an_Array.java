import java.util.*;

/**
 * 🔹 Problem: Find All Numbers Disappeared in an Array
 * 🔹 Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * 🔹 Platform: LeetCode
 * 🔹 Category: Arrays
 * 
 * 🔹 Problem Statement:
 * Given an array nums of size n where nums[i] is in the range [1, n],
 * return all the integers in the range [1, n] that do not appear in nums.
 * 
 * ------------------------------------------------------------
 * 🔹 Approaches Implemented:
 * 
 * 1. Counting Array (Extra Space)
 * 2. Sorting Approach
 * 3. In-Place Marking (Optimal Solution)
 * ------------------------------------------------------------
 */

public class Solution {

    /**
     * 🔹 Approach 1: Counting Array (Extra Space)
     * 
     * Algorithm:
     * - Create a count array of size n
     * - Store frequency of each number
     * - Traverse count array:
     *      If count[i] == 0 → missing number (i + 1)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public List<Integer> findDisappearedNumbers_Counting(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - 1]++;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                list.add(i + 1);
            }
        }

        return list;
    }


    /**
     * 🔹 Approach 2: Sorting
     * 
     * Algorithm:
     * - Sort the array
     * - Traverse from 1 to n and compare with array elements
     * - Track missing numbers
     * 
     * Time Complexity: O(n log n)
     * Space Complexity: O(1) (ignoring sorting space)
     */
    public List<Integer> findDisappearedNumbers_Sorting(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        int expected = 1;
        int i = 0;

        while (expected <= nums.length) {
            if (i < nums.length && nums[i] == expected) {
                i++;
            } else {
                list.add(expected);
            }
            expected++;
        }

        return list;
    }


    /**
     * 🔹 Approach 3: In-Place Marking (Optimal Solution)
     * 
     * Algorithm:
     * - Use index marking technique
     * - For each number:
     *      Mark index (num - 1) as negative
     * - Traverse array:
     *      If value is positive → missing number
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public List<Integer> findDisappearedNumbers_Optimal(int[] nums) {
        List<Integer> list = new ArrayList<>();

        // Mark visited indices
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Find missing numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}
