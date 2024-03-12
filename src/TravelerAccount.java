import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TravelerAccount {
    private int distance;
    private int health;
    private Lock accountLock;

    public TravelerAccount() {
        distance = 0;
        health = 100; // Assuming starting health is 100
        accountLock = new ReentrantLock();
    }

    public void increaseDistance(int amount) {
        accountLock.lock();
        try {
            distance += amount;
        } finally {
            accountLock.unlock();
        }
    }

    public void decreaseHealth(int amount) {
        accountLock.lock();
        try {
            health -= amount;
        } finally {
            accountLock.unlock();
        }
    }

    public void heal(int amount) {
        accountLock.lock();
        try {
            health += amount;
            if (health > 100) {
                health = 100; // Cap health to 100
            }
        } finally {
            accountLock.unlock();
        }
    }

    public int getDistance() {
        return distance;
    }

    public int getHealth() {
        return health;
    }
}
