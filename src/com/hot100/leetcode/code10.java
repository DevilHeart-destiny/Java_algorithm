/**
 * 560. 和为 K 的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 *
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 *
 * 提示：
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */

package com.hot100.leetcode;

import java.util.HashMap;
import java.util.Map;

public class code10 {
    public static void main(String[] args) {
        code10 s = new code10();
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(s.subarraySum(nums,k));
    }
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int prefix = 0;
        Map<Integer,Integer> hash = new HashMap<>();
        hash.put(0,1);
        for (int num : nums) {
            prefix += num;
            if(hash.containsKey(prefix-k))
            {
                res += hash.get(prefix-k);
            }
            hash.put(prefix,hash.getOrDefault(prefix,0)+1);
        }
        return res;
    }
}
