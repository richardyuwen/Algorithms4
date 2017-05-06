package com.alg4.ch1.p1;

import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by i305765 on 13/04/2017.
 */
public class UFTest {

    static int count;
    static ArrayList<Integer> c1;
    static ArrayList<Integer> c2;

    @Before
    public void PrepareData() throws Exception {
        Scanner scanner = new Scanner(new FileInputStream("data/mediumUF.txt"));
        count = scanner.nextInt();
        c1 = new ArrayList<Integer>();
        c2 = new ArrayList<Integer>();
        while (scanner.hasNextInt()) {
            c1.add(scanner.nextInt());
            c2.add(scanner.nextInt());
        }
    }

    @Test
    public void TestQuickFindUF() {
        UF uf = new QuickFindUF(count);
        for (int i = 0; i < c1.size(); i++) {
            uf.union(c1.get(i), c2.get(i));
        }
        System.out.println("count:" + uf.count);
    }

    @Test
    public void TestQuickUnionUF() {
        UF uf = new QuickUnionUF(count);
        for (int i = 0; i < c1.size(); i++) {
            uf.union(c1.get(i), c2.get(i));
        }
        System.out.println("count:" + uf.count);
    }

    @Test
    public void TestWeightedQuickUnionUF() {
        UF uf = new WeightedQuickUnionUF(count);
        for (int i = 0; i < c1.size(); i++) {
            uf.union(c1.get(i), c2.get(i));
        }
        System.out.println("count:" + uf.count);
    }
}
