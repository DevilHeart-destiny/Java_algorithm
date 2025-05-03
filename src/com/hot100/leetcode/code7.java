/**
 * 42. 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 *
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 */

package com.hot100.leetcode;

import java.util.Stack;

public class code7 {
    public static void main(String[] args) {
        code7 s = new code7();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(height));
    }
    public int trap(int[] height) {
        if(height.length <= 2) return 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int res = 0;
        for (int i = 1; i < height.length; i++) {
            if(height[st.peek()] == height[i])
            {
                st.pop();
                st.push(i);
            }
            else if(height[st.peek()] > height[i])
            {
                st.push(i);
            }
            else
            {
                while(!st.empty() && height[st.peek()] < height[i])
                {
                    int mid = st.pop();
                    if(!st.empty())
                    {
                        int h = Math.min(height[st.peek()],height[i])-height[mid];
                        int w = i - st.peek() - 1;
                        res += h * w;
                    }
                }
                st.push(i);
            }
        }
        return res;
    }
}
