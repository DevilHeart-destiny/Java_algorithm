/**
 * 49. 字母异位词分组
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例 1:
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 *
 * 提示：
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */

package com.hot100.leetcode;

import java.util.*;
import java.util.stream.Stream;

public class code2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            String sorted;
            char[] chararray = str.toCharArray();
            Arrays.sort(chararray);
            sorted = new String(chararray);
            if(map.containsKey(sorted))
            {
                map.get(sorted).add(str);
            }
            else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                map.put(sorted,tmp);
            }
        }
        map.forEach((key,value)->{
            res.add(value);
        });
        return res;
    }
    public static void main(String[] args) {
        code2 s = new code2();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = s.groupAnagrams(strs);
        for(List<String> group : res)
        {
            for (String s1 : group) {
                System.out.print(s1 + " ");
            }
            System.out.println();
        }
    }
}