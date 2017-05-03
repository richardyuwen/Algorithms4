package com.lc.depth_first_search;

/**
 * Created by i305765 on 15/04/2017.
 */
public class CaptureSurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 0)
            return;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O' && visited[0][i] == false)
                explore(0, i, board, visited);
            if (board[row - 1][i] == 'O' && visited[0][i] == false)
                explore(row - 1, i, board, visited);
        }

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O' && visited[i][0] == false)
                explore(i, 0, board, visited);
            if (board[i][column - 1] == 'O' && visited[i][column - 1] == false)
                explore(i, column - 1, board, visited);
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O' && visited[i][j] == false) {
                    board[i][j] = 'X';
                }
            }
        }

    }

    void explore(int i, int j, char[][] board, boolean[][] visited) {
        visited[i][j] = true;
        int row = board.length;
        int column = board[0].length;
        int d[][] = {
                new int[]{
                        0, -1
                },
                new int[]{
                        -1, 0
                },
                new int[]{
                        0, 1
                },
                new int[]{
                        1, 0
                }
        };
        for (int di = 0; di < d.length; di++) {
            int xi = i + d[di][0];
            int xj = j + d[di][1];
            if (xi < 0 || xj < 0 || xi >= row || xj >= column) {
                continue;
            }
            if (board[xi][xj] == 'O' && visited[xi][xj] == false) {
                explore(xi, xj, board, visited);
            }
        }
    }

}
