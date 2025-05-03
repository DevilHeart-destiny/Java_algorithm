/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * 示例 1:
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * 输入: nums = [0]
 * 输出: [0]
 *
 * 提示:
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * 进阶：你能尽量减少完成的操作次数吗
 */

package com.hot100.leetcode;

public class code4 {
    public static void main(String[] args) {
        code4 s = new code4();
        int[] nums = {0,1,0,3,12};
        s.moveZeroes(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length)
        {
            if(nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        while(slow < nums.length)
        {
            nums[slow++] = 0;
        }
    }
}
