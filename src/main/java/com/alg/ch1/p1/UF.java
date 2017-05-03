package com.alg.ch1.p1;

abstract public class UF {
    protected int count;
    protected int[] id;

    public UF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p,int q)
    {
        return find(p)==find(q);
    }
    abstract public int find(int p);

    abstract public void union(int p,int q);
}