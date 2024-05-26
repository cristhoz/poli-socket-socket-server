package co.edu.poligran.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private final int port;

    public ChatServer(int port) {
        this.port = port;
    }

    public void execute() {
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server socket started on port " + port);

            while(true) {
                 Socket clientSocket = serverSocket.accept();
                 System.out.println("New user connected");
                 new UserThread(clientSocket).run();
            }
        } catch (IOException e) {
            System.out.println("Error starting the server socket on port " + port);
            e.printStackTrace();
        }
    }
}
