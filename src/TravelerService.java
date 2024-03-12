import java.io.*;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class TravelerService implements Runnable {
    private final Socket clientSocket;
    private final Traveler traveler;
    private PrintWriter out;
    private Scanner in;

    public TravelerService(Socket clientSocket, Traveler traveler) {
        this.clientSocket = clientSocket;
        this.traveler = traveler;
    }


    @Override
    public void run() {
        try  {
            in = new Scanner(clientSocket.getInputStream());
            out = new PrintWriter(clientSocket.getOutputStream());
            doService();
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

    public void doService() throws IOException
    {
        while (true)
        {
            if (!in.hasNext()) { return; }
            String command = in.next();
            if (command.equals("QUIT")) { return; }
            else { executeCommand(command); }
        }
    }

//    private void executeCommand(String command, PrintWriter writer) throws NoSuchElementException {
//        switch (command) {
//            case "MOVE 10":
//                traveler.move(10);
//                int remaining = traveler.getGoalDistance();
//                writer.println("You moved 10 units. Remaining distance: " + remaining);
//                break;
//            case "HEAL":
//                traveler.heal();
//                writer.println("You healed yourself.");
//                break;
//            case "DO_NOTHING":
//                traveler.doNothing();
//                writer.println("You decided to do nothing.");
//                break;
//            default:
//                writer.println("Invalid command");
//                break;
//        }
//        writer.flush();

    private void executeCommand(String command) throws NoSuchElementException {
        int player = in.nextInt();
        if(command.equals("MOVE"))
        {
            traveler.move(player + in.nextInt());
            int remaining = traveler.getGoalDistance();
            out.println("You moved 10 units. Remaining distance: " + remaining);
        }
        else if(command.equals("HEAL"))
        {
            traveler.heal();
            out.println("You healed yourself.");
        }
        else if(command.equals("DO_NOTHING"))
        {
            traveler.doNothing();
            out.println("You decided to do nothing.");
        }
        out.flush();
    }
}
