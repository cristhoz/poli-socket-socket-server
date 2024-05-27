package co.edu.poligran.server;

import java.io.*;
import java.net.Socket;

public class UserThread {
    private final Socket clientSocket;
    private final BufferedReader reader;
    private final PrintWriter writer;

    public UserThread(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        this.writer = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public void run() {
        try {
            String message;
            while((message = reader.readLine()) != null) {
                System.out.println(message + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error in UserThread: " + e.getMessage());
        } finally {
            try {
                reader.close();
                writer.close();
                clientSocket.close();
            } catch (IOException e) {
                System.out.println("Error closing the client socket: " + e.getMessage());
            }
        }
    }
}
