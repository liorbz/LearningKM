package com.nice.elsa.elsifyer.impl.keyphrase;

import org.junit.Assert;
import org.junit.Test;

import javax.validation.constraints.AssertTrue;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class KeyphraseExtarctorTest {

    private KeyphraseExtractor keyphraseExtractor = new KeyphraseExtractor();

    @Test
    public void test() throws IOException {
        //httppost.setEntity(new StringEntity("I have a problem with my TV screen, please help"));
        //httppost.setEntity(new StringEntity("My router is flashing, what should I do?"));
        //httppost.setEntity(new StringEntity("I heard that you have promotion for sport bundle…"));
        //httppost.setEntity(new StringEntity("Do you have sport bundle?"));
        //httppost.setEntity(new StringEntity("How can I open the sport bundle?"));
        Set<String> keyphrases = keyphraseExtractor.getKeyphrases("\"Good morning,  What is the price of the sport bundle?\"");

        //keyphrases.stream().forEach(System.out::println);
        Assert.assertTrue(keyphrases.contains("sport"));
        Assert.assertTrue(keyphrases.contains("bundle"));
        Assert.assertTrue(keyphrases.contains("price"));
        Assert.assertTrue(keyphrases.contains("morning"));

    }

}
