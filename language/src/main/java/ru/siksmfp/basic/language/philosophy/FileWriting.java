package ru.siksmfp.basic.language.philosophy;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWriting {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/parkito/GitHub/learning/BasicDataStructuresAndAlgorithms/language/src/main/java/ru/siksmfp/basic/language/philosophy/file1.txt");
        byte[] bytes = "Writing to file".getBytes();

        FileWriting fr = new FileWriting();
        fr.fileOutputStream(file, bytes);
        System.out.println();
        fr.bufferWriting(file, bytes);
        System.out.println();
        fr.dataOutputStream(file);
    }

    private void fileOutputStream(File file, byte[] bytes) throws IOException {
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(bytes);
        }
    }

    private void bufferWriting(File file, byte[] bytes) throws IOException {
        int bufferSize = 1024;
        try (OutputStream os = new BufferedOutputStream(new FileOutputStream(file), bufferSize)) {
            os.write(bytes);
        }
    }

    private void dataOutputStream(File file) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(1);
        }
    }
}
