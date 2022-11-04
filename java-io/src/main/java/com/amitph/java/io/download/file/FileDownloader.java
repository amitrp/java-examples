package com.amitph.java.io.download.file;

import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FileDownloader {

    public static void main(String[] a) throws IOException, URISyntaxException, InterruptedException, ExecutionException {
        FileDownloader fileDownloader = new FileDownloader();
        String from = "https://www.google.com";
        String to = "/temp/file/path";

        fileDownloader.usingPlainJava(from, to);
        fileDownloader.usingFiles(from, to);
        fileDownloader.usingNio(from, to);
        fileDownloader.usingHttpClient(from, to);
        fileDownloader.usingHttpClientAsync(from, to);
        fileDownloader.usingCommonsIo(from, to);
    }

    public void usingPlainJava(String from, String to) throws IOException {
        URL url = new URL(from);
        try (
                InputStream inputStream = url.openStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                FileOutputStream fileOutputStream = new FileOutputStream(to)
        ) {
            byte[] bucket = new byte[2048];
            int numBytesRead;

            while ((numBytesRead = bufferedInputStream.read(bucket, 0, bucket.length)) != -1) {
                fileOutputStream.write(bucket, 0, numBytesRead);
            }
        }
    }

    public void usingFiles(String from, String to) throws IOException {
        URL url = new URL(from);
        try (InputStream inputStream = url.openStream()) {
            Files.copy(inputStream, Paths.get(to));
        }
    }

    public void usingNio(String from, String to) throws IOException {
        URL url = new URL(from);
        try (
                ReadableByteChannel inputChannel = Channels.newChannel(url.openStream());

                FileOutputStream fileOutputStream = new FileOutputStream(to);
                FileChannel outputChannel = fileOutputStream.getChannel()
        ) {
            outputChannel.transferFrom(inputChannel, 0, Long.MAX_VALUE);
        }
    }

    public void usingHttpClient(String from, String to) throws IOException, URISyntaxException, InterruptedException {
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(new URI(from))
                .GET()
                .build();

        HttpResponse<InputStream> response = httpClient.send(httpRequest, responseInfo -> HttpResponse.BodySubscribers.ofInputStream());
        Files.copy(response.body(), Paths.get(to));
    }

    public void usingHttpClientAsync(String from, String to) throws IOException, URISyntaxException, InterruptedException, ExecutionException {
        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest
                .newBuilder()
                .uri(new URI(from))
                .GET()
                .build();

        Future<InputStream> futureInputStream = httpClient
                .sendAsync(httpRequest, HttpResponse.BodyHandlers.ofInputStream())
                .thenApply(HttpResponse::body);

        InputStream inputStream = futureInputStream.get();
        Files.copy(inputStream, Path.of(to));
    }


    public void usingCommonsIo(String from, String to) throws IOException {
        URL url = new URL(from);
        FileUtils.copyURLToFile(url, new File(to));
    }
}