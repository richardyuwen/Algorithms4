package com.alg.ch5.p1;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.junit.Assert.*;

/**
 * Created by i305765 on 05/05/2017.
 */
public class KMPTest {
    Logger logger = LoggerFactory.getLogger(KMPTest.class);
    @Test
    public void search() throws Exception {
        String text = "ABCBACABBACAB";
        String pattern = "BBA";
        KMP kmp = new KMP();
        int index = kmp.search(text, pattern);
        String subString = text.substring(index, pattern.length() + index);
        logger.info("Sub string:",subString);
    }

}