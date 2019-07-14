package ru.siksmfp.basic.language.philosophy.selector;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        String hostName = "localhost";
        int port = 2141;

        Server server = Server.startNewServerProcess(hostName, port);
        Client client = Client.startNewClient(hostName, port);

        client.send("one");
        String resp1 = client.receive();
        System.out.println(resp1);

        server.destroy();
        client.destroy();
    }
}
