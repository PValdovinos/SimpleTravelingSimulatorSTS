import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TravelerClient
{
    public static void main(String[] args) throws IOException
    {

        //TO DO: Implement Scanners so that the player has time to input their "actions"

        final int SBAP_PORT = 8888;
        try (Socket s = new Socket("localhost", SBAP_PORT))
        {
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
            Scanner scanner = new Scanner(instream);
            PrintWriter printWriter = new PrintWriter(outstream);

            Scanner consoleInput = new Scanner(System.in);

            System.out.println("Welcome to the Traveler Game!");
            System.out.println("Commands: MOVE [distance], HEAL, DO_NOTHING, QUIT");

            boolean running = true;
            while (running) {
                System.out.print("Enter command: ");
                String command = consoleInput.nextLine().trim();

                // Send command to the server
                printWriter.println(command);

                // Receive response from the server
                String response = scanner.nextLine();
                System.out.println("Server response: " + response);

                // Check if the server response indicates the end of the game
                if (response.startsWith("Game Over")) {
                    running = false;
                }
            }
        }
    }
}
