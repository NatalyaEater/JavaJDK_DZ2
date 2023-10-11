package org.example;

import org.example.client.ClientGUI;
import org.example.server.ServerWindow;
import org.example.server.Storage;
import org.example.server.ServerGUI;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        ServerWindow serverWindow = new ServerWindow(storage);
        ServerGUI serverGUI = new ServerGUI(serverWindow);
        new ClientGUI(serverGUI);
        new ClientGUI(serverGUI);
    }
}