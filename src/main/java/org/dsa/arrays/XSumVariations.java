package org.dsa.arrays;

import java.util.*;

public class XSumVariations {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) != null) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    // 2Sum Follow up: What if the input array is sorted?
    public int[] twoSumSortedArray(int[] nums, int target) {
        int[] res = new int[2];

        if (nums == null || nums.length == 0) {
            return res;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
            if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    // 2Sum Variant: Find how many pairs in the array such that their sum is less than or equal to a specific target number.

    /*
    We use count += right - left because we know that the sum of current left number and any numbers before current right number
    will be less than the target.
     For example, if we have number 1, 2, 3, 4, 5 ,6 and the target is 8, then we know that
     */
    public int two_Sum_Count_Pairs_Less_Or_Equal_To_Target(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] <= target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }


    //2Sum Variant: Find the sum of the two integers such that the sum is closest to target.

    public int twoSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1];
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                bestSum = sum;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return bestSum;
    }

    //2Sum Variant: Find how many unique pairs in the array such that their sum is equal to a specific target number.
    /*
        Input:
        nums = [1, 1, 2, 45, 46, 46], target = 47

       Output:
        2

        Explanation:
        1 + 46 = 47
        2 + 45 = 47
        Hence, return 2 sets.
     */

    public int twoSum_count_pairs(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int count = 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                count++;
                left++;
                right--;
                // moving left pointer to right to skip duplicates
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                // moving right pointer to left to skip duplicates
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        return count;
    }

    // 3Sum: Given an array nums of n integers, find all unique triplets in the array which gives the sum of zero.
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1, right = nums.length - 1;

            while (left < right) {

                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);

                    left++;
                    right--;

                    // moving left pointer to right to skip duplicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // moving right pointer to left to skip duplicates
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return results;
    }

    // 3Sum Variant: Find three integers in nums such that the sum is closest to target.

    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return -1;
        }
        Arrays.sort(nums);
        int bestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return bestSum;
    }

    // 4Sum: Given an array nums of n integers and an integer target, find all unique quadruplets in the array which gives the sum of target.

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                // skip duplicates
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {

                    if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[left]);
                        result.add(nums[right]);
                        results.add(result);

                        left++;
                        right--;

                        // moving left pointer to right to skip duplicates
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        // moving right pointer to left to skip duplicates
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return results;
    }


    // 4Sum Variant: Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
    /*
    Input:
    A = [ 1, 2]
    B = [-2,-1]
    C = [-1, 2]
    D = [ 0, 2]

    Output:
    2

    Explanation:
    The two tuples are:
    1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */

    public int fourSumCount_equals_zero(int[] A, int[] B, int[] C, int[] D) {

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }
                else {
                    map.put(sum, 1);
                }
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = -(C[i] + D[j]);
                if (map.containsKey(sum)) {
                    count += map.get(sum);
                }
            }
        }
        return count;
    }


}
