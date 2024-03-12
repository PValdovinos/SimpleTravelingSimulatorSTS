import java.io.*;
import java.net.Socket;

public class TravelerService implements Runnable {
    private final Socket clientSocket;
    private final Traveler traveler;

    public TravelerService(Socket clientSocket, Traveler traveler) {
        this.clientSocket = clientSocket;
        this.traveler = traveler;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String command;
            while ((command = reader.readLine()) != null) {
                if (command.equals("QUIT")) {
                    break;
                } else {
                    executeCommand(command, writer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void executeCommand(String command, PrintWriter writer) {
        switch (command) {
            case "MOVE 10":
                traveler.move(10);
                int remaining = traveler.getGoalDistance();
                writer.println("You moved 10 units. Remaining distance: " + remaining);
                break;
            case "HEAL":
                traveler.heal();
                writer.println("You healed yourself.");
                break;
            case "DO_NOTHING":
                traveler.doNothing();
                writer.println("You decided to do nothing.");
                break;
            default:
                writer.println("Invalid command");
                break;
        }
        writer.flush();
    }
}
