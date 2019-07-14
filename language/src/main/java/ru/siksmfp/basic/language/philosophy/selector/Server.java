package ru.siksmfp.basic.language.philosophy.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server {
    private ServerSocketChannel serverSocket;
    private String hostName;
    private int port;

    private Server(String hostName, int port) {
        this.hostName = hostName;
        this.port = port;
    }

    public static Server startNewServerProcess(String hostName, int port) {
        return new Server(hostName, port);
    }

    public void start() {
        try {
            Selector selector = Selector.open();
            serverSocket = ServerSocketChannel.open();
            serverSocket.bind(new InetSocketAddress(hostName, port));
            serverSocket.configureBlocking(false);
            serverSocket.register(selector, SelectionKey.OP_ACCEPT);

            while (true) {
                selector.select();
                Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    SelectionKey key = iter.next();

                    if (key.isAcceptable()) {
                        register(selector, serverSocket);
                    }

                    if (key.isReadable()) {
                        answerWithEcho(key);
                    }

                    iter.remove();
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void destroy() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void register(Selector selector, ServerSocketChannel serverSocket) throws IOException {
        SocketChannel client = serverSocket.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
    }

    private static void answerWithEcho(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        client.read(buffer);
        System.out.println("Message received " + new String(buffer.array()));

        buffer = ByteBuffer.wrap("Message accepted".getBytes());
        buffer.flip();
        client.write(buffer);
        buffer.clear();
    }

    public static void main(String[] args) {
        Server server = Server.startNewServerProcess("localhost", 2141);
        server.start();
    }

    //    public static Process startNewServerProcess(String hostName, Integer port) throws IOException {
//        String javaHome = System.getProperty("java.home");
//        String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
//        String classpath = System.getProperty("java.class.path");
//        String className = Server.class.getCanonicalName();
//
//        return new ProcessBuilder(javaBin, "-cp", classpath, className, hostName, port.toString())
//                .start();

//    }
}
