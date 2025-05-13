/**
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 示例 1：
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 *
 * 提示：
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 */
package com.hot100.leetcode;

public class code18 {
    public static void main(String[] args) {
        code18 s = new code18();
//        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] matrix = {{1,0}};
        s.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int colum = matrix[0].length;
        boolean row_zero = false;
        boolean colum_zero = false;
        for(int i = 0; i < row; i++)
        {
            if(matrix[i][0] == 0)
            {
                row_zero = true;
                break;
            }
        }
        for(int j = 0; j < colum; j++)
        {
            if(matrix[0][j] == 0)
            {
                colum_zero = true;
                break;
            }
        }

        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < colum; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < colum; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row_zero)
        {
            for(int i = 0; i < row; i++)
            {
                matrix[i][0] = 0;
            }
        }
        if(colum_zero)
        {
            for(int j = 0; j < colum; j++)
            {
                matrix[0][j] = 0;
            }
        }
    }
}
