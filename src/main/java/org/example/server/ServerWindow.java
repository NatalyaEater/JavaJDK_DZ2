package org.example.server;

import org.example.client.Client;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ServerWindow extends JFrame {

    List<Client> clientList;
    private boolean work;
    private final Storage storage;
    private final ServerGUI serverGUI;

    public ServerWindow(Storage storage) {

        this.storage = storage;
        serverGUI = new ServerGUI(this);
        clientList = new ArrayList<>();
    }

    public void connect() {
        if (work) {
            printText("Сервер уже был запущен");
        } else {
            work = true;
            printText("Сервер запущен!");
        }
    }

    public void disconnect() {
        if (!work){
            printText("Сервер уже был остановлен");
        } else {
            work = false;
            for (Client client: clientList){
                disconnectUser(client);
            }
            //TODO поправить удаление
            printText("Сервер остановлен!");
        }
    }

    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnect();
        }
    }

    public String getHistory() {
        return storage.readLog();
    }

    public void sendMessage(String text){
        if (!work){
            return;
        }
        printText(text);
        answerAll(text);
        printText(text);
    }
    private void printText(String text){
        serverGUI.showMessage(text);
    }

    private void answerAll(String text){
        for (Client client: clientList){
            client.serverAnswer(text);
        }
    }

}
