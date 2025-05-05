/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */

package com.hot100.leetcode;

import java.util.HashMap;
import java.util.Map;

public class code8 {
    public static void main(String[] args) {
        code8 s = new code8();
        String str = "abcabcbb";
        System.out.println(s.lengthOfLongestSubstring(str));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> window = new HashMap<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while(right < s.length())
        {
            char r = s.charAt(right);
            right++;
            window.put(r,window.getOrDefault(r,0)+1);
            while(window.get(r) > 1)
            {
                char l = s.charAt(left);
                window.put(l,window.get(l)-1);
                left++;
            }
            res = Math.max(res,right-left);
        }
        return res;
    }
}
