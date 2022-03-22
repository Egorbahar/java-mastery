package com.godeltech.l5pt5;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;

public class NIO_2_PT {

    public static class Server {
        private static final InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8889);
        private static final Path filePath = Paths.get("src/main/resources/nio_2_pt.txt");

        public static void main(String[] args) throws IOException {

            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(inetSocketAddress);
            serverSocketChannel.configureBlocking(false);
            final int ops = serverSocketChannel.validOps();
            SelectionKey selectionKey = serverSocketChannel.register(selector, ops, null);
            while (true) {
                System.out.println("I'm a server and I'm waiting for new connection and buffer select...");
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> selectionKeyIterator = selectionKeys.iterator();
                while (selectionKeyIterator.hasNext()) {
                    SelectionKey myKey = selectionKeyIterator.next();
                    if (myKey.isAcceptable()) {
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        System.out.println("Connection Accepted: " + socketChannel.getLocalAddress());
                    } else if (myKey.isReadable()) {
                        SocketChannel socketChannel = (SocketChannel) myKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(256);
                        socketChannel.read(byteBuffer);
                        String result = new String(byteBuffer.array()).trim();
                        System.out.println("Message received: " + result);
                        try {
                            Files.writeString(filePath, result, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
                            System.out.println("Writing in file");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        if (result.contains("client")) {
                            socketChannel.close();
                        }
                    }
                    selectionKeyIterator.remove();
                }
            }
        }
    }

    public static class Client {
        private static final InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost", 8889);

        public static void main(String[] args) throws IOException {
            SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
            System.out.println("Connecting to Server on port 8888...");
            String message = "Message for server from client";
            byte[] test = message.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(test);
            socketChannel.write(buffer);
            buffer.clear();
            System.out.println("sending: " + message);
            socketChannel.close();
        }
    }
}
