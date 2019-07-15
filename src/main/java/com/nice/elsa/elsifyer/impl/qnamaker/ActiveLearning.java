package com.nice.elsa.elsifyer.impl.qnamaker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ActiveLearning {

    private static final String TRAIN_URL = "https://elsasparkathon.azurewebsites.net/qnamaker/knowledgebases/30873dae-8a46-4122-8445-a38387df7b4d/train";
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public boolean train(String userId, String userQuestion, long qnaId) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(TRAIN_URL);

        httppost.setHeader("Content-Type", "application/json");
        httppost.setHeader("Authorization", "a9794ff7-7e23-4e5a-9b16-617fac921aa6");

        FeedbackRecordDTO feedbackRecordDTO = new FeedbackRecordDTO(userId, userQuestion, qnaId);
        FeedbackDTO feedbackDTO = new FeedbackDTO(Collections.singletonList(feedbackRecordDTO));
        String feedbackString = gson.toJson(feedbackDTO, FeedbackDTO.class);
        System.out.println(feedbackString);

        httppost.setEntity(new StringEntity(feedbackString));

        //Execute and get the response.
        HttpResponse httpResponse = httpclient.execute(httppost);
        int statusCode = httpResponse.getStatusLine().getStatusCode();

        if (statusCode<200 || statusCode>=300) {
            System.out.println("Failed to send training data");
            System.out.println("Status code: "+statusCode);
            System.out.println(httpResponse.getStatusLine().getReasonPhrase());
            return false;
        }

        return true;
    }
}
