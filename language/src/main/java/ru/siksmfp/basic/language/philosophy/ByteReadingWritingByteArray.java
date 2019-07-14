package ru.siksmfp.basic.language.philosophy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteReadingWritingByteArray {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "Hello".getBytes();

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        output.write(bytes);
        System.out.println(output.toString());

        InputStream input = new ByteArrayInputStream(bytes);
        int data = input.read();
        while (data != -1) {
            System.out.println((char) data);
            data = input.read();
        }
    }
}
