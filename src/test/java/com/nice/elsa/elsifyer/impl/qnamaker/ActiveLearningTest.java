package com.nice.elsa.elsifyer.impl.qnamaker;

import org.junit.Test;

import java.io.IOException;

public class ActiveLearningTest {

    @Test
    public void testActiveLearning() throws IOException {
        ActiveLearning activeLearning = new ActiveLearning();
        boolean succeed = activeLearning.train("liorbenz@nice.com", "My browser stuck", 7);
    }
}
