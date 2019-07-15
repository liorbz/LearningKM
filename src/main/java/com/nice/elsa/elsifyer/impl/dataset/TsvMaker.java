package com.nice.elsa.elsifyer.impl.dataset;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class TsvMaker {
    public static void main(String[] args) throws IOException {
        DatasetParser datasetParser = new DatasetParser();
        Map<String, String> kb = datasetParser.parse("train_tickets.csv");
        FileWriter fileWriter = new FileWriter("train_tickets.tsv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Question\tAnswer\n");
        Set<Map.Entry<String, String>> entries = kb.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            bufferedWriter.write(entry.getKey()+'\t'+entry.getValue()+'\n');
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
