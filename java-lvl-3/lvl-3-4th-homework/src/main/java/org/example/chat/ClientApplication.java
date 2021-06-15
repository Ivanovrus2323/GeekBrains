package org.example.chat;

import org.example.chat.client.Client;

import java.io.IOException;

public class ClientApplication {
    public static void main(String[] args) throws IOException {
        Client.start();
    }
}