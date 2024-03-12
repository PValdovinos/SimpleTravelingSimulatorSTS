import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TravelerService implements Runnable {

    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Traveler traveler;

    /**
     * Constructs a service object that processes commands
     * from a socket for a traveler.
     *
     * @param aSocket the socket
     * @param aTrav   the traveler
     */
    public TravelerService(Socket aSocket, Traveler aTrav) {
        s = aSocket;
        traveler = aTrav;
    }

    public void run() {
        try {
            try {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            } finally {
                s.close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Executes all commands until the QUIT command or the
     * end of input.
     */
    public void doService() throws IOException {
        while (true) {
            if (!in.hasNext()) {
                return;
            }
            String command = in.next();
            if (command.equals("QUIT")) {
                return;
            } else {
                executeCommand(command);
            }
        }
    }

    /**
     * Executes a single command.
     *
     * @param command the command to execute
     */
    public void executeCommand(String command) {
        switch (command) {
            case "MOVE":
                int distance = in.nextInt();
                traveler.move(distance);
                int remaining = traveler.getGoalDistance() - distance;
                System.out.println("You are now ");
                break;
            case "HEAL":
                traveler.heal();
                break;
            case "DO_NOTHING":
                traveler.doNothing();
                break;
            default:
                out.println("Invalid command");
                out.flush();
                break;
        }
    }
}