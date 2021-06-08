package org.example.chat.server;

import java.sql.*;

public class BaseDatabaseService implements DbService {

    private static Connection connection;
    private static Statement stmt;

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        disconnect();
        System.out.println("Сервис аутентификации остановлен");
    }

    public BaseDatabaseService() throws SQLException {
        connect();
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/network_chat", "test2", "password");
        stmt = connection.createStatement();
    }

    public void disconnect() {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getNickByLoginPass(String login, String pass) throws SQLException {
        ResultSet resultSet = stmt.executeQuery("SELECT nick FROM users WHERE LOWER(login) = '" + login.toLowerCase() + "' and password = '" + pass + "'");
        while (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }

    @Override
    public void changeNick(String newNick, String login) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement("UPDATE users SET nick = '" + newNick + "' WHERE login = '" + login + "'");
        pstmt.executeUpdate();
    }
}