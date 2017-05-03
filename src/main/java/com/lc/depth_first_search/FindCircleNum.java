package com.lc.depth_first_search;

/**
 * Created by i305765 on 13/04/2017.
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int count = 0;
        int size = M[0].length;
        int[] visited = new int[size];
        for (int i = 0; i < size; i++) {
            if (visited[i] == 0) {
                count++;
                explore(i, visited, M);
            }
        }
        return count;
    }

    public void explore(int startPoint, int[] visited, int[][] adjMatrix) {
        visited[startPoint] = 1;
        int[] adjLine = adjMatrix[startPoint];
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == 0 && adjLine[i] == 1) {
                explore(i, visited, adjMatrix);
            }
        }
    }
}
