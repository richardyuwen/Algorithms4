package com.lc.union_find;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by i305765 on 13/04/2017.
 */
public class CaptureSurroundedRegions {
    public void solve(char[][] board) {
        int row = board.length;
        if (row <= 0)
            return;
        int column = board[0].length;
        int[] id = new int[row * column];
        int[] sz = new int[row * column];
        for (int i = 0; i < row * column; i++) {
            id[i] = i;
            sz[i] = 1;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    List<Integer> list = connectedEdges(board, id, i, j);
                    for (int k = 0; k < list.size(); k++) {
                        union(id, sz, i * column + j, list.get(k));
                    }
                }
            }
        }
        HashSet connectedSet = new HashSet<Integer>();
        for (int i = 0; i < column; i++) {
            if (board[0][i] == 'O') {
                int c = find(id, i);
                connectedSet.add(c);
            }
            if (board[row - 1][i] == 'O') {
                int c = find(id, (row - 1) * column + i);
                connectedSet.add(c);
            }
        }

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                int c = find(id, i * column);
                connectedSet.add(c);
            }
            if (board[i][column - 1] == 'O') {
                int c = find(id, i * column + column - 1);
                connectedSet.add(c);
            }
        }

        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < column - 1; j++) {
                if (board[i][j] == 'O') {
                    int c = find(id, i * column + j);
                    if (!connectedSet.contains(c)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    List<Integer> connectedEdges(char[][] board, int[] id, int i, int j) {
        int d[][] = {
                new int[]{
                        0, -1
                },
                new int[]{
                        -1, 0
                }
        };
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k = 0; k < d.length; k++) {
            int xi = i + d[k][0];
            int xj = j + d[k][1];
            if (xi < 0 || xj < 0 || xi >= board.length || xj >= board[0].length) {
                continue;
            }
            if (board[xi][xj] == 'O') {
                list.add(xi * board[0].length + xj);
            }
        }
        return list;
    }

    int find(int[] id, int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    void union(int[] id, int[] sz, int p, int q) {
        int cp = find(id, p);
        int cq = find(id, q);

        if (cp == cq)
            return;
        if (sz[cp] < sz[cq]) {
            id[cp] = cq;
            sz[cq] += sz[cp];
        } else {
            id[cq] = cp;
            sz[cp] += sz[cq];
        }
        return;
    }
}
