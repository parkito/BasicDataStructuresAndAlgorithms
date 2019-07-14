package ru.siksmfp.basic.language.philosophy;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileReading {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/parkito/GitHub/learning/BasicDataStructuresAndAlgorithms/language/src/main/java/ru/siksmfp/basic/language/philosophy/file.txt");

        FileReading fr = new FileReading();
        fr.fileInputStream(file);
        System.out.println();
        fr.randomAccessFile(file);
        System.out.println();
        fr.bufferReading(file);
        System.out.println();
        fr.pushBackReading(file);
        System.out.println();
        fr.sequenceFileReading(file);
        System.out.println();
        fr.dataInputStream(file);
        System.out.println();
        fr.fileChannel(file);
    }

    private void fileInputStream(File file) throws IOException {

        try (InputStream is = new FileInputStream(file)) {
            int data = is.read();
            while (data != -1) {
                System.out.print((char) data);
                data = is.read();
            }
        }
    }

    private void randomAccessFile(File file) throws IOException {

        try (RandomAccessFile is = new RandomAccessFile(file, "rw")) {
            System.out.println("Size " + is.length());
            int data = is.read();
            while (data != -1) {
                System.out.print((char) data);
                data = is.read();
            }
        }
    }

    private void bufferReading(File file) throws IOException {
        int bufferSize = 1024;
        try (InputStream input = new BufferedInputStream(new FileInputStream(file), bufferSize)) {
            int data = input.read();
            while (data != -1) {
                System.out.print((char) data);
                data = input.read();
            }
        }
    }

    private void pushBackReading(File file) throws IOException {
        PushbackInputStream input = new PushbackInputStream(new FileInputStream(file));

        int data = input.read();
        while (data != -1) {
            if ((char) data == 's') {
                System.out.print("s");
                input.unread(data);
                input.read();
            }
            System.out.print((char) data);
            data = input.read();
        }
    }

    private void sequenceFileReading(File file) throws IOException {
        try (InputStream input1 = new FileInputStream(file);
             InputStream input2 = new FileInputStream(file)) {
            SequenceInputStream sequenceInputStream = new SequenceInputStream(input1, input2);

            int data = sequenceInputStream.read();
            while (data != -1) {
                System.out.print((char) data);
                data = sequenceInputStream.read();
            }
        }
    }

    private void dataInputStream(File file) throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            int aByte = dataInputStream.read();
            System.out.println((char) aByte);
        }
    }

    private void fileChannel(File file) throws IOException {
        try (RandomAccessFile aFile = new RandomAccessFile(file, "rw");
             FileChannel inChannel = aFile.getChannel()) {
            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = inChannel.read(buf);
            while (bytesRead != -1) {

                System.out.println("Read " + bytesRead);
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                buf.clear();
                bytesRead = inChannel.read(buf);
            }
        }
    }
}
