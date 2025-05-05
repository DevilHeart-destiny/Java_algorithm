/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *  示例 2:
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *
 * 提示:
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 */

package com.hot100.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class code9 {
    public static void main(String[] args) {
        code9 s = new code9();
        String str = "cbaebabacd";
        String model = "abc";
        List<Integer> res = s.findAnagrams(str,model);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character,Integer> window = new HashMap<>();
        Map<Character,Integer> need = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        for(char c : p.toCharArray())
        {
            need.put(c,need.getOrDefault(c,0)+1);
        }
        while(right < s.length())
        {
            char r = s.charAt(right);
            right++;
            if(need.containsKey(r))
            {
                window.put(r,window.getOrDefault(r,0)+1);
                if(window.get(r).equals(need.get(r)))
                {
                    valid++;
                }
            }
            while(right - left >= p.length())
            {
                if(valid == need.size())
                {
                    res.add(left);
                }
                char l = s.charAt(left);
                left++;
                if(need.containsKey(l))
                {
                    if(need.get(l).equals(window.get(l)))
                    {
                        valid--;
                    }
                    window.put(l,window.get(l)-1);
                }
            }
        }
        return res;
    }
}
