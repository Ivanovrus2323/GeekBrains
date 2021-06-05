package org.example.server;

import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements AuthService {

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }

    public BaseAuthService() {

    }

    @Override
    public String getNickByLoginPass(String login, String pass) {
        //if (o.getLogin().equals(login) && o.getPass().equals(pass)) return o.getNick();

        return null;
    }
}