import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TravelerServer
{
    public static void main(String[] args) throws IOException
    {
        final int PLAYER_HP = 30;
        Traveler traveler = new Traveler(PLAYER_HP, 100);
        final int SBAP_PORT = 8888;
        ServerSocket server = new ServerSocket(SBAP_PORT);
        System.out.println("Waiting for clients to connect...");

        while (true)
        {
            Socket s = server.accept();
            System.out.println("Client connected.");
            TravelerService service = new TravelerService(s, traveler);
            Thread t = new Thread(service);
            t.start();
        }
    }
}
