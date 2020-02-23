package queuewithstack;

import java.util.Optional;

public class UpdateMatrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int[][] res = new int[matrix.length][matrix[0].length];
        for (int r = 0; r < res.length; r++) {
            for (int c = 0; c < res[0].length; c++) {
                res[r][c] = -1;
            }
        }
        dfs(matrix,res,0,0);
        return res;
    }

    public void dfs(int[][] matrix, int[][] res, int r, int c) {
        boolean flag = matrix[r][c] ==0;
        if (r >= 1) {
            if (flag) {
                res[r - 1][c] = 1;
            } else {
                //判断其邻居最小距离+1
                dfs(matrix, res, r - 1, c);
            }
        }
        if (c >= 1) {
            if (flag) {
                res[r ][c-1] = 1;
            } else {
                dfs(matrix, res, r, c-1);
            }
        }
        if (r +1<matrix.length) {
            if (flag) {
                res[r+ 1][c] = 1;
            } else {
                dfs(matrix, res, r + 1, c);
            }
        }
        if (c+1<matrix[0].length) {
            if (flag) {
                res[r ][c+1] = 1;
            } else {
                dfs(matrix, res, r , c+1);
            }
        }

    }

    public int[][] updateMatrixDp(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return matrix;
        }
        int cols = matrix[0].length;

        int[][] dist = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dist[r][c]=Integer.MAX_VALUE-10000;
            }
        }

        //check for left and top
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                    }
                }
            }
        }

        //check for bottom and right
        for (int i = rows-1; i >= 0; i--) {
            for (int j = cols-1; j >=0; j--) {

                    if (i <rows-1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                    }
                    if (j <cols-1) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
                    }

            }
        }
        return dist;
    }


}
