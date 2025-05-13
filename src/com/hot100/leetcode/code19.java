/**
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */

package com.hot100.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code19 {
    public static void main(String[] args) {
        code19 s = new code19();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = s.spiralOrder(matrix);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0) return new ArrayList<Integer>();
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int idx = 0;
        Integer[] res = new Integer[(r+1)*(b+1)];
        while(true)
        {
            // left -> right
            for(int i = l; i <= r; i++)
            {
                res[idx++] = matrix[t][i];
            }
            if(++t > b) break;
            // top -> bottom
            for(int i = t; i <= b; i++)
            {
                res[idx++] = matrix[i][r];
            }
            if(--r < l) break;
            // right -> left
            for(int i = r; i >= l; i--)
            {
                res[idx++] = matrix[b][i];
            }
            if(--b < t) break;
            // bottom -> top
            for(int i = b; i >= t; i--)
            {
                res[idx++] = matrix[i][l];
            }
            if(++l > r) break;
        }
        return Arrays.asList(res);
    }
}
