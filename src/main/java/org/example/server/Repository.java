package org.example.server;

public interface Repository {
    String readLog();
    void saveInLog(String text);

}
