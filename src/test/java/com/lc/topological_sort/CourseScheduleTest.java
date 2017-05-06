package com.lc.topological_sort;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * Created by i305765 on 06/05/2017.
 */
public class CourseScheduleTest {
    final Logger logger = LoggerFactory.getLogger(CourseScheduleTest.class);

    @Test
    public void findOrder() throws Exception {

        int nCourses = 4;
        int[][] prerequisites = new int[][]{
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };

        int[] orders = CourseSchedule.findOrder(nCourses, prerequisites);
        logger.info("orders:{}", orders);
    }

}