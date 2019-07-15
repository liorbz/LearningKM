package com.nice.elsa.elsifyer.impl.service.qna;

import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class QnaManagerImpl implements QnaManager {

    private final String KB_ENDPOINT = "https://elsasparkathon.azurewebsites.net/qnamaker/knowledgebases/30873dae-8a46-4122-8445-a38387df7b4d";
    private final String API_GENERATE_ANSWER = "/generateAnswer";
    private final String KB_KEY = "a9794ff7-7e23-4e5a-9b16-617fac921aa6";
    private final String AUTH_HEADER = "Authorization";
    private final String AUTH_TYPE = "EndpointKey";
    private final String CNT_TYPE_HEADER = "Content-Type";
    private final String CNT_TYPE = "application/json";
    private final int TOP_ANSWER_COUNT = 3;

    @Override
    public QnaAnswerResponse generateAnswer(String question) {
        QnaAnswerResponse qnaResponse = null;
        Gson gson = new Gson();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost postRequest = new HttpPost(KB_ENDPOINT.concat(API_GENERATE_ANSWER));

        // Headers
        postRequest.setHeader(AUTH_HEADER, AUTH_TYPE.concat(" ").concat(KB_KEY));
        postRequest.setHeader(CNT_TYPE_HEADER, CNT_TYPE);

        // Request body
        QnaAnswerRequest ansRequest = new QnaAnswerRequest(question, TOP_ANSWER_COUNT);
        try {
            postRequest.setEntity(new StringEntity(gson.toJson(ansRequest)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("request: " + EntityUtils.toString(postRequest.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        CloseableHttpResponse response = null;
        try {
            response = client.execute(postRequest);
            HttpEntity ent = response.getEntity();
            InputStream responseStream = ent.getContent();

            if (responseStream != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(responseStream));
                qnaResponse = gson.fromJson(reader, QnaAnswerResponse.class);
                System.out.println(response.getStatusLine().getStatusCode());
                System.out.println("response: " + EntityUtils.toString(ent));

            }
            EntityUtils.consume(ent);

        } catch (IOException e) {
            e.printStackTrace();
            qnaResponse = null;
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return qnaResponse;
    }
}
