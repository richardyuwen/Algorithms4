package com.lc.topological_sort;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by i305765 on 22/04/2017.
 */
public class CourseSchedule {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] edges = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new LinkedList<>();
        }
        int[] inDegrees = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            edges[from].add(to);
            inDegrees[to]++;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0) {
                deque.offer(i);
            }
        }
        int[] orders = new int[numCourses];
        int index = 0;
        while (deque.size() > 0) {
            int i = deque.poll();
            orders[index++] = i;
            for (Integer to : edges[i]) {
                --inDegrees[to.intValue()];
                if (inDegrees[to.intValue()] == 0) {
                    deque.offer(to);
                }
            }
        }
        //cyclic detect
        if (index == 0 || index < numCourses) {
            return new int[0];
        }
        return orders;
    }
}
