package com.alg4.ch1.p1;

/**
 * Created by i305765 on 13/04/2017.
 */
public class QuickFindUF extends UF {

    QuickFindUF(int N) {
        super(N);
    }

    public int find(int p) {
        return id[p];
    }

    public void union(int p, int q) {
        int cp = find(p);
        int cq = find(q);
        if (cp == cq)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == cp)
                id[i] = cq;
        }
        count--;
    }
}
