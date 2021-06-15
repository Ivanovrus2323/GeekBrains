package org.example.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private final int PORT = 8189;

    private List<ClientHandler> clients;
    private DbService dbService;

    public DbService getAuthService() {
        return dbService;
    }

    public Server() {
        try (ServerSocket server = new ServerSocket(PORT)) {
            dbService = new BaseDatabaseService();
            dbService.start();
            clients = new ArrayList<>();
            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println("Клиент подключился");
                new ClientHandler(this, socket);
            }
        } catch (IOException | SQLException e) {
            System.out.println("Ошибка в работе сервера");
            System.out.println(e.getMessage());
        } finally {
            if (dbService != null) {
                dbService.stop();
            }
        }
    }

    public synchronized boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void broadcastMsg(String msg) {
        for (ClientHandler o : clients) {
            o.sendMsg(msg);
        }
    }

    public synchronized void broadcastMsg(String msg, String nick) {
        for (ClientHandler o : clients) {
            if (o.getName() != nick) o.sendMsg(msg);
        }
    }

    public synchronized void broadcastMsg(String msg, String nick, String nick2) {
        for (ClientHandler o : clients) {
            if (o.getName() != nick && o.getName().equals(nick2)) o.sendMsg(msg);
        }
    }

    public synchronized void changeNick(String oldNick, String newNick, String login) throws SQLException {
        dbService.changeNick(newNick, login);
        broadcastMsg(oldNick + " сменил ник на " + newNick);
    }

    public synchronized void unsubscribe(ClientHandler o) {
        clients.remove(o);
    }

    public synchronized void subscribe(ClientHandler o) {
        clients.add(o);
    }
}
