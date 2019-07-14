package ru.siksmfp.basic.language.philosophy.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

class Client {
    private SocketChannel client;

    private Client(String hostName, int port) {
        try {
            client = SocketChannel.open(new InetSocketAddress(hostName, port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client startNewClient(String hostName, int port) {
        return new Client(hostName, port);
    }

    public void destroy() throws IOException {
        client.close();
    }

    public void send(String message) {
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        try {
            client.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receive() {
        try {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            client.read(buffer);
            return new String(buffer.array());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Client client = Client.startNewClient("localhost", 2141);
        client.send("message");
        System.out.println(client.receive());
    }
}

