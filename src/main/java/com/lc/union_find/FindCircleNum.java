package com.lc.union_find;

/**
 * Created by i305765 on 13/04/2017.
 */
public class FindCircleNum {

    public int findCircleNum(int[][] M) {
        int count = M[0].length;
        int[] id = new int[count];
        int size = count;
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (M[i][j] == 1 && i != j) {
                    if (union(id,i,j)==true){
                        count--;
                    }
                }
            }
        return count;
    }

    public int find(int[] id, int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    public boolean union(int[] id, int p, int q) {
        int cp = find(id,p);
        int cq = find(id,q);
        if (cp==cq)
            return false;
        id[cp] = cq;
        return true;
    }
}
