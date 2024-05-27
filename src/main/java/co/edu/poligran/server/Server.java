package co.edu.poligran.server;

import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        System.out.println("Initialize the server socket application...");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the port number to start the server socket: ");
        int port = scanner.nextInt();

        new ChatServer(port).execute();
    }
}
