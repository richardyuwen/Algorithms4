package com.alg.ch5.p1;
/**
 * Created by i305765 on 05/05/2017.
 */
public class KMP {

    public int search(String text, String pattern) {
        int[] dfa = getDFA(pattern);
        return searchInDFA(text, dfa, pattern);
    }

    public int searchInDFA(String text, int[] dfa, String pattern) {
        int k = -1;
        int j = 0;
        int i = 0;
        for (; i < text.length() && j < pattern.length(); ) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                continue;
            } else {
                int nextJ = dfa[j];
                if (nextJ != -1) {
                    j = nextJ;
                } else {
                    j = 0;
                    i++;
                }
            }
        }
        if (j == pattern.length()) {
            return i - j;
        }
        return -1;
    }

    public int[] getDFA(String pattern) {
        int[] dfa = new int[pattern.length()];
        dfa[0] = -1;
        for (int i = 1; i < pattern.length(); i++) {
            int k = dfa[i - 1];
            do {
                while (k != -1) {
                    if (pattern.charAt(k) == pattern.charAt(i - 1)) {
                        break;
                    } else {
                        k = dfa[k];
                    }
                }
                if (pattern.charAt(i) != pattern.charAt(k + 1)) {
                    break;
                } else if (k == -1) {
                    k = -2;
                    break;
                }
            } while (true);
            dfa[i] = k + 1;
        }
        return dfa;
    }
}
