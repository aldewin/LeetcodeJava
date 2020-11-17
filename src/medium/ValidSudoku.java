package medium;

/**
 * 36. Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 */

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board = {
                new char[]{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                new char[]{'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                new char[]{'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                new char[]{'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board){
        if (board == null && board.length != 9 && board[0].length != 9)
            return false;

        for (int i = 0; i < 9; i++) {
            boolean[] repeatNumbers = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int idx = (int) board[i][j] - '1';
                    if (repeatNumbers[idx])
                        return false;
                    repeatNumbers[idx] = true;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            boolean[] repeatNumbers = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    int idx = (int) board[i][j] - '1';
                    if (repeatNumbers[idx])
                        return false;
                    repeatNumbers[idx] = true;
                }
            }
        }

        for (int block = 0; block < 9; block++) {
            boolean[] repeatNumbers = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        int idx = (int) board[i][j] - '1';
                        if (repeatNumbers[idx])
                            return false;
                        repeatNumbers[idx] = true;
                    }
                }
            }
        }

        return true;
    }
}
