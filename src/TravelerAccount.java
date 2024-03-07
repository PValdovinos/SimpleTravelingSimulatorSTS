import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TravelerAccount {

    /**
     * A traveler account has "actions" that can be chosen by using
     * their respective terms.
     */
    private int distance;
    private int unitMovement;
    private int health;
    private int healingItems;
    private Lock distanceChangeLock;

    // TO DO: Implement scanners into methods to ensure player can choose their actions.

    Scanner scanner = new Scanner(System.in);

    /**
     * Constructs a traveler awaiting their "journey".
     */
    public TravelerAccount() {
        distance = 0;
        distanceChangeLock = new ReentrantLock();
    }

    /**
     * Allows player to choose journey length.
     *
     * @param distance the amount to move to reach your goal
     */
    public void journey(int distance) {
        distanceChangeLock.lock();
        try {
            //String newDistanceToGoal = "You now have to move" + (distance) - amount;
            balance = newBalance;
        } finally {
            balanceChangeLock.unlock();
        }
    }

    /**
     * Player chooses how far they wish to move towards their destination.
     *
     * @param unitMovement the amount to move towards goal
     */
    public void walk(int unitMovement) {
        distanceChangeLock.lock();
        try {
            int newDistanceToGoal = Integer.parseInt("You now have to move" + (distance - unitMovement));
        }
        finally
        {
            distanceChangeLock.unlock();
        }
    }

    /**
     * Heals the player a certain amount (Will be randomly generated between 1-12).
     *
     * @return a string acknowledging having healed
     */
    public int heal()
    {
        distanceChangeLock.lock();
        try
        {

        }
    }

    /**
     * Gets the current health of the player (Will be randomly generated within reason).
     *
     * @return the current balance
     */
    public String health()
    {
        return "You're not looking too hot...";
    }

    public String doNothing()
    {
        return "You decide to wait and do nothing... kinda lonely";
    }
}
