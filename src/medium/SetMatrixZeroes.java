package medium; /**
 * 73. Set Matrix Zeroes
 *
 * https://leetcode.com/problems/set-matrix-zeroes/
 */

import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {

    }

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> idxI = new ArrayList<>();
        List<Integer> idxJ = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    idxI.add(i);
                    idxJ.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0)
                    continue;
                if (idxI.indexOf(i) != -1 || idxJ.indexOf(j) != -1)
                    matrix[i][j] = 0;
            }
        }
    }
}
