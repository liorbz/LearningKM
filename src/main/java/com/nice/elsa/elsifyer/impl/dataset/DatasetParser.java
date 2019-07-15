package com.nice.elsa.elsifyer.impl.dataset;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DatasetParser {
    public static void main(String[] args) throws IOException, InterruptedException {
        DatasetParser datasetParser = new DatasetParser();
        datasetParser.parse("train_tickets.csv");
    }

    public Map<String, String> parse(String filename) throws IOException {
        InputStream resourceAsStream = new ClassPathResource("/"+filename).getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
        Map<String, String> result = new HashMap<>();
        String line = null;
        // skip header
        bufferedReader.readLine();

        while ((line = bufferedReader.readLine()) != null) {
            //System.out.println("line: "+line);
            String question = null;
            int qStartIndex=line.indexOf(',')+1;
            int qStartApos=line.indexOf('"');
            //System.out.println("qStartApos: "+qStartApos);
            //System.out.println("qStartIndex: "+qStartIndex);

            int aStartIndex=line.indexOf(',', qStartIndex+1);

            if (qStartApos==-1 || (aStartIndex<qStartApos && qStartApos>0)) {
                question=line.substring(qStartIndex, aStartIndex);
            } else {
                int qEndIndex=line.indexOf('"', qStartIndex+2);
                question=line.substring(qStartIndex, qEndIndex);
                aStartIndex=line.indexOf(',',qEndIndex+1);
            }

            int aEndIndex=line.lastIndexOf(',');

            if (line.charAt(aStartIndex+1)=='"') {
                aStartIndex++;
            }

            if (line.charAt(aEndIndex-1)=='"') {
                aEndIndex--;
            }

            String answer=line.substring(aStartIndex+1, aEndIndex);

            //System.out.println("Q: "+question);
            //System.out.println("A: "+answer);
            System.out.println();

            result.put(question, answer);
        }

        bufferedReader.close();

        return result;
    }
}
