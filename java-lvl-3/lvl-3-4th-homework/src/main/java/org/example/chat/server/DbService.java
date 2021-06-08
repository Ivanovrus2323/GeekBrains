package org.example.chat.server;

import java.sql.SQLException;

public interface DbService {
    void start();
    String getNickByLoginPass(String login, String pass) throws SQLException;
    void stop();
    void connect() throws SQLException;
    void disconnect();
    void changeNick(String newNick, String login) throws SQLException;
}