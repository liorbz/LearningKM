package com.nice.elsa.elsifyer.impl.keyphrase;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeyphraseExtractor {

//    private static final Gson gson = new Gson();
    private static final JsonParser JSON_PARSER = new JsonParser();



    public Set<String> getKeyphrases(String s) throws IOException {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("http://languages.cortical.io/rest/text/keywords?retina_name=en_general");

        httppost.setHeader("Content-Type", "application/json");
        httppost.setEntity(new StringEntity(s));

        //Execute and get the response.
        HttpResponse httpResponse = httpclient.execute(httppost);
        HttpEntity entity = httpResponse.getEntity();

        Set<String> result = new HashSet<>();

        if (entity != null) {
            String response = EntityUtils.toString(entity);
            JsonArray jsonArray = (JSON_PARSER).parse(response).getAsJsonArray();

            for (int i=0; i<jsonArray.size(); i++) {
                String keyphrase = jsonArray.get(i).getAsString();
                result.add(keyphrase);
            }
        }

        return result;
    }
}
