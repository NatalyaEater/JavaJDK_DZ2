package org.example.server;

import lombok.Data;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
@Data

public class ServerGUI extends JFrame {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    JButton btnStart, btnStop;
    JTextArea log;

    private final ServerWindow serverWindow;

    public ServerGUI(ServerWindow serverWindow){
        this.serverWindow = serverWindow;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }

    public void appendLog(String text){
        log.append(text + "\n");
    }
    public void showMessage(String text) {
        appendLog(text);
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverWindow.connect();
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serverWindow.disconnect();
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

}
