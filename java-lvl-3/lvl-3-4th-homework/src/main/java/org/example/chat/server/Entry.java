package org.example.chat.server;

public class Entry {
    private String login;
    private String pass;
    private String nick;

    public Entry(String login, String pass, String nick) {
        this.login = login;
        this.pass = pass;
        this.nick = nick;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public String getNick() {
        return nick;
    }
}