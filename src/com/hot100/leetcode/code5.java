/**
 * 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49
 */

package com.hot100.leetcode;

public class code5 {
    public static void main(String[] args) {
        code5 s = new code5();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(height));
    }
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = 0;
        while(left < right)
        {
            res = height[left] < height[right] ?
                    Math.max(res,(right-left)*height[left++]):
                    Math.max(res,(right-left)*height[right--]);//后面的(right-left)和height[right--]一定不能写反，要先计算宽度然后再缩小范围
        }
        return res;
    }
}
