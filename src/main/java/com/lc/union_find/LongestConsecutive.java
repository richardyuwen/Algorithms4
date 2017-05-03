package com.lc.union_find;

import java.io.InterruptedIOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by i305765 on 14/04/2017.
 */
public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> id2P = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> sz = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            id2P.put(nums[i], nums[i]);
            sz.put(nums[i], 1);
        }

        for (int i = 0; i < nums.length; i++) {
            union(nums[i], id2P, sz);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : sz.entrySet()) {
            if (entry.getValue().intValue() > max) {
                max = entry.getValue().intValue();
            }
        }
        return max;
    }

    Integer find(Integer p, Map<Integer, Integer> id2P) {
        while (!id2P.get(p).equals(p)) {
            p = id2P.get(p);
        }
        return p;
    }

    void union(int p, Map<Integer, Integer> id2P, Map<Integer, Integer> sz) {
        if (!id2P.containsKey(p + 1)) {
            return;
        }
        Integer cpp1 = find(p + 1, id2P);
        Integer cp = find(p, id2P);
        if (cpp1.compareTo(cp) == 0)
            return;
        if (sz.get(cpp1).compareTo(sz.get(cp)) < 0) {
            id2P.put(cpp1, cp);
            sz.put(cp, sz.get(cpp1).intValue() + sz.get(cp).intValue());
        } else {
            id2P.put(cp, cpp1);
            sz.put(cpp1, sz.get(cpp1).intValue() + sz.get(cp).intValue());
        }
    }
}
