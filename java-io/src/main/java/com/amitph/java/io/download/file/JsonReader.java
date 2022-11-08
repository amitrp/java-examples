package com.amitph.java.io.download.file;

import com.amitph.java.io.download.file.model.Response;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

public class JsonReader {
    public static void main(String[] arg) throws IOException {
        String from = "https://randomuser.me/api/";
        JsonReader jsonReader = new JsonReader();
        System.out.println(jsonReader.readJsonStringUsingPlainJava(from));
        System.out.println(jsonReader.readJsonStringUsingCommonsIo(from));
        System.out.println(jsonReader.readJsonObjectUsingJackson(from));
        System.out.println(jsonReader.readJsonCustomObjectUsingJackson(from));
    }

    public String readJsonStringUsingPlainJava(String from) throws IOException {
        URL url = new URL(from);
        StringBuilder builder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream(), UTF_8))) {
            String str;
            while ((str = bufferedReader.readLine()) != null) {
                builder.append(str);
            }
        }
        return builder.toString();
    }

    public String readJsonStringUsingCommonsIo(String from) throws IOException {
        URL url = new URL(from);
        return IOUtils.toString(url, UTF_8);
    }

    public JsonNode readJsonObjectUsingJackson(String from) throws IOException {
        return new ObjectMapper().readTree(new URL(from));
    }

    public Response readJsonCustomObjectUsingJackson(String from) throws IOException {
        return new ObjectMapper().readValue(new URL(from), Response.class);
    }
}