import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TravelerClient {
    public static void main(String[] args) throws IOException {
        final int SBAP_PORT = 8888;

        try (Socket s = new Socket("localhost", SBAP_PORT)) {
            InputStream instream = s.getInputStream();
            OutputStream outstream = s.getOutputStream();
            Scanner in = new Scanner(instream);
            PrintWriter out = new PrintWriter(outstream);

            String command = "MOVE 1 10";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            String response = in.nextLine();
            System.out.println("Response: " + response);


            command = "HEAL";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Response: " + response);

            command = "DO_NOTHING";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
            response = in.nextLine();
            System.out.println("Response: " + response);

            command = "QUIT";
            System.out.println("Sending: " + command);
            out.print(command + "\n");
            out.flush();
        }
    }
}
