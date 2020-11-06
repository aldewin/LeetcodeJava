package medium;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                new int[] {1, 5, 9},
                new int[] {10, 11, 13},
                new int[] {12, 13, 15}
        };
        System.out.println(kthSmallest(matrix, 8));
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        long left = matrix[0][0] - 1L; // < answer
        long right = matrix[n - 1][n - 1]; // >= answer
        /*
            [1, 5, 9]
            [10, 11, 13]
            [12, 13, 15]
         */
        while (left + 1 < right) {
            long mid = (left + right) / 2;
            int j = n;
            int count = 0;
            for (int i = 0; i < n && j > 0; i++) {
                while (j - 1 >= 0 && matrix[i][j - 1] >= mid)
                    j--;
                count += j;
            }
            if (count < k)
                left = mid;
            else
                right = mid;

        }
        return (int)right;
    }
}
