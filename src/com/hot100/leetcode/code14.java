/**
 * 56. 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 提示：
 * 1 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 104
 */

package com.hot100.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class code14 {
    public static void main(String[] args) {
        code14 s = new code14();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = s.merge(intervals);
        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new LinkedList<>();
        Arrays.sort(intervals,(x,y)->Integer.compare(x[0],y[0]));
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] <= res.get(res.size()-1)[1])
            {
                int tmp_right = Math.max(res.get(res.size()-1)[1],intervals[i][1]);
                res.set(res.size()-1, new int[]{res.get(res.size() - 1)[0], tmp_right});
            }
            else {
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
