package com.amitph.java.io;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class InputStreamToByteArray {
    public InputStream toInputStream(byte[] bytes) {
        return new ByteArrayInputStream(bytes);
    }

    public byte[] toByteArrayUsingPlainJava(InputStream inputStream) throws IOException {
        int size = inputStream.available();
        byte[] bytes = new byte[size];
        inputStream.read(bytes);
        return bytes;
    }

    public byte[] toByteArrayManually(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] bucket = new byte[1024];
        int nReadBytes;
        while ((nReadBytes = inputStream.read(bucket, 0, bucket.length)) != -1) {
            byteArrayOutputStream.write(bucket, 0, nReadBytes);
        }

        return byteArrayOutputStream.toByteArray();
    }

    public byte[] toByteArrayUsingApacheCommons(InputStream inputStream) throws IOException {
        return IOUtils.toByteArray(inputStream);
    }

    public byte[] toByteArrayUsingGuava(InputStream inputStream) throws IOException {
        return ByteStreams.toByteArray(inputStream);
    }

    public static void main(String[] a) throws IOException {
        InputStreamToByteArray converter = new InputStreamToByteArray();
        byte[] input =
                """
                "this sample text that we will convert
                to a byte[] then to InputStream"
                """
                        .getBytes(UTF_8);

        InputStream inputStream1 = converter.toInputStream(input);
        System.out.println("InputStream to byte[] using plain Java");
        System.out.println(new String(converter.toByteArrayUsingPlainJava(inputStream1)));

        InputStream inputStream2 = converter.toInputStream(input);
        System.out.println("InputStream to byte[] using plain Manually");
        System.out.println(new String(converter.toByteArrayManually(inputStream2)));

        InputStream inputStream3 = converter.toInputStream(input);
        System.out.println("InputStream to byte[] using Apache Commons IO");
        System.out.println(new String(converter.toByteArrayUsingApacheCommons(inputStream3)));

        InputStream inputStream4 = converter.toInputStream(input);
        System.out.println("InputStream to byte[] using plain Guava");
        System.out.println(new String(converter.toByteArrayUsingGuava(inputStream4)));
    }
}
