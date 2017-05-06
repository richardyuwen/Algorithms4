package com.alg4.ch1.p1;

/**
 * Created by i305765 on 13/04/2017.
 */
public class WeightedQuickUnionUF extends UF {

    int[] sz;

    WeightedQuickUnionUF(int N) {
        super(N);
        sz = new int[N];
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    public int find(int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int cp = find(p);
        int cq = find(q);
        if (cp == cq)
            return;

        if (sz[cp] < sz[cq]) {
            id[cp] = cq;
            sz[cq] += sz[cp];
        } else {
            id[cq] = cp;
            sz[cp] += sz[cq];
        }
        count--;
        return;
    }
}
