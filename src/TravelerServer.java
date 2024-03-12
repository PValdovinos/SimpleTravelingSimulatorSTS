import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TravelerServer {
    public static void main(String[] args) {
        final int PLAYER_HP = 30;
        final int SBAP_PORT = 8888;

        try (ServerSocket server = new ServerSocket(SBAP_PORT)) {
            System.out.println("Waiting for clients to connect...");
            Traveler traveler = new Traveler(PLAYER_HP, 100);

            while (true) {
                Socket clientSocket = server.accept();
                System.out.println("Client connected.");
                TravelerService service = new TravelerService(clientSocket, traveler);
                Thread t = new Thread(service);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
