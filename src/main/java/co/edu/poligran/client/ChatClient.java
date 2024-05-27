package co.edu.poligran.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private final String ip;
    private final int port;
    private final String userName;

    public ChatClient(String ip, int port, String userName) {
        this.ip = ip;
        this.port = port;
        this.userName = userName;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);

        DataInputStream in;
        DataOutputStream out;

        try {
            sendMessage("> " + userName + " has joined the chat");

            System.out.println("Enter your message: ");
            String message = scanner.nextLine();

            sendMessage("> " + userName + ": " + message);
        } catch (IOException e) {
            System.out.println("Error connecting to the server");
        }
    }

    private void sendMessage(String message) throws IOException {
        try(Socket socket = new Socket(ip, port)) {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(message);
        }
    }
}
