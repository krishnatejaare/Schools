package com.example.krishnatejaare.schools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Krishna Teja Are on 4/16/2018.
 */

public class http {
    public String read(String httpUrl) throws IOException {
        String httpData = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        URL url = new URL(httpUrl);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        System.out.println(httpURLConnection.getResponseCode());
        httpURLConnection.connect();
        System.out.println(httpURLConnection.getResponseCode());

        inputStream = httpURLConnection.getInputStream();
        System.out.println(httpURLConnection.getResponseCode());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
        }

        httpData = stringBuffer.toString();
        bufferedReader.close();
        inputStream.close();
        httpURLConnection.disconnect();

        return httpData;
    }
}
