/**
 * 128. 最长连续序列
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 * 示例 3：
 * 输入：nums = [1,0,1,2]
 * 输出：3
 *
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */

package com.hot100.leetcode;

import java.util.HashSet;
import java.util.Set;

public class code3 {
    public static void main(String[] args) {
        code3 s = new code3();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(s.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 1;
        for (Integer i : set) {
            if(!set.contains(i-1))
            {
                int tmp = i;
                int curlen = 1;
                while(set.contains(tmp+1))
                {
                    tmp++;
                    curlen++;
                }
                res = Math.max(res,curlen);
            }
        }
        return res;
    }
}
