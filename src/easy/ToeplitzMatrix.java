package easy;

/**
 * 766. Toeplitz Matrix
 *
 * https://leetcode.com/problems/toeplitz-matrix/
 */

public class ToeplitzMatrix {
    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix1(new int[][] {new int[] {18}, new int[] {66}}));
        System.out.println(isToeplitzMatrix1(new int[][] {
                new int[] {1, 2, 3, 4},
                new int[] {5, 1, 2, 3},
                new int[] {9, 5, 1, 2}
        }));
    }

    // Runtime: 1 ms, Memory: 39.7 MB
    public static boolean  isToeplitzMatrix1(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1])
                    return false;
            }
        }
        return true;
    }

    // Runtime: 1 ms, Memory: 39.4
    public static boolean isToeplitzMatrix2(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    int value = matrix[i][j];
                    int newI = i + 1;
                    int newJ = j + 1;
                    while (newI < n && newJ < m) {
                        if (value != matrix[newI][newJ])
                            return false;
                        newI++;
                        newJ++;
                    }
                }
            }
        }
        return true;
    }
}
