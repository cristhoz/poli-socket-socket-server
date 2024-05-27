package co.edu.poligran.client;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        System.out.println("Initialize the client socket application...");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the server IP address: ");
        String ip = scanner.nextLine();
        System.out.println("Enter the server port number: ");
        int port = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();

        new ChatClient(ip, port, userName).execute();
    }
}
