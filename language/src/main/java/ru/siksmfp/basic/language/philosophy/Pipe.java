package ru.siksmfp.basic.language.philosophy;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//Remember,when using the two connected pipe streams,pass one stream to one thread,
//and the other stream to another thread.
//The read()and write()calls on the streams are blocking,
//meaning if you try to use the same thread
//  to both read and write,this may result in the thread deadlocking itself.

public class Pipe {

    public static void main(String[] args) throws IOException, InterruptedException {
        try (PipedOutputStream output = new PipedOutputStream();
             PipedInputStream input = new PipedInputStream()) {
            input.connect(output);

            Thread thread1 = new Thread(() -> {
                try {
                    output.write("Hello world, pipe!".getBytes());
                } catch (IOException ignored) {
                }
            });

            Thread thread2 = new Thread(() -> {
                try {
                    int data = input.read();
                    while (data != -1) {
                        System.out.print((char) data);
                        data = input.read();
                    }
                } catch (IOException ignored) {
                }
            });

            thread1.start();
            thread2.start();

            thread2.join();
        }
    }
}
