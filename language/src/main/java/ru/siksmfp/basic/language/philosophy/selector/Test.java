package ru.siksmfp.basic.language.philosophy.selector;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int port = 2141;

        Process server = Server.startNewServerProcess(hostName, port);
        Client client = Client.startNewClient(hostName, port);

        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");

        server.destroy();
        client.stop();
    }
}
