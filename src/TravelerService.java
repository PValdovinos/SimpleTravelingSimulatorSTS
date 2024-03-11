import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TravelerService implements Runnable
{

    private Socket s;
    private Scanner in;
    private PrintWriter out;
    private Traveler traveler;

    /**
     Constructs a service object that processes commands
     from a socket for a traveler.
     @param aSocket the socket
     @param aTrav the traveler
     */
    public TravelerService(Socket aSocket, Traveler aTrav)
    {
        s = aSocket;
        traveler = aTrav;
    }

    public void run()
    {
        try
        {
            try
            {
                in = new Scanner(s.getInputStream());
                out = new PrintWriter(s.getOutputStream());
                doService();
            }
            finally
            {
                s.close();
            }
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
    }

    /**
     Executes all commands until the QUIT command or the
     end of input.
     */
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

    /**
     Executes a single command.
     @param command the command to execute
     */
    public void executeCommand(String command)
    {
        switch (command) {
            case "MOVE":
                int distance = in.nextInt();
                int damageChance = (int) (Math.random() * 10); // Random damage chance
                if (damageChance == 0) {
                    traveler.damaged(); // Implement this method in Player class
                    out.println("You moved " + distance + " units, but you took damage!");
                } else {
                    out.println("You moved " + distance + " units safely.");
                }
                out.flush();
                break;
            case "HEAL":
                int healAmount = (int) (Math.random() * 5) + 1; // Random heal amount (1-5)
                traveler.heal(healAmount); // Implement this method in Player class
                out.println("You healed yourself for " + healAmount + " HP.");
                out.flush();
                break;
            case "CHECK_HEALTH":
                int currentHP = traveler.getHP(); // Implement this method in Player class
                out.println("Your remaining HP: " + currentHP);
                out.flush();
                break;
            default:
                out.println("Invalid command");
                out.flush();
                break;
    }
}
