package com.alg4.ch1.p1;

/**
 * Created by i305765 on 13/04/2017.
 */
public class QuickUnionUF extends UF {
    QuickUnionUF(int N) {
        super(N);
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
        id[cp] = cq;
        count--;
        return;
    }
}
