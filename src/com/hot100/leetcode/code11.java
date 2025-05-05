/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 *
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 *
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */

package com.hot100.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class code11 {
    public static void main(String[] args) {
        code11 s = new code11();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = s.maxSlidingWindow(nums,k);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }
    class myqueue{
        Deque<Integer> qu = new LinkedList<>();
        void poll(int val){
            if(!qu.isEmpty() && val == qu.peek())
            {
                qu.remove();
            }
        }
        void add(int val)
        {
            while(!qu.isEmpty() && val > qu.getLast())
            {
                qu.removeLast();
            }
            qu.add(val);
        }
        int peek(){
            return qu.getFirst();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 1) return nums;
        myqueue q = new myqueue();
        int[] res = new int[nums.length-k+1];
        int index = 0;
        for(int i = 0; i < k; i++)
        {
            q.add(nums[i]);
        }
        res[index++] = q.peek();
        for(int i = k; i < nums.length; i++)
        {
            q.poll(nums[i-k]);
            q.add(nums[i]);
            res[index++] = q.peek();
        }
        return res;
    }
}
