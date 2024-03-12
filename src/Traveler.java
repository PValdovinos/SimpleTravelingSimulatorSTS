import java.util.Random;

public class Traveler {
    private TravelerAccount[] players;
    private int hp;
    private int goalDistance;

    /**
     * Constructs a bank account with a given number of accounts.
     *
     * @param size the number of accounts
     */
    public Traveler(int size, int goalDistance) {
        this.goalDistance = goalDistance;
        players = new TravelerAccount[size];
        for (int i = 0; i < players.length; i++) {
            players[i] = new TravelerAccount();
        }
    }

    public int getGoalDistance()
    {
        return goalDistance;
    }

    public void setGoalDistance(int goalDistance)
    {
        this.goalDistance = goalDistance;
    }

    /**
     * Allows player to decide the length of their game.
     *
     * @param playerNum the player number
     * @param amount    the amount to move to complete their game
     */
//    public void journey(int playerNum, double amount) {
//        TravelerAccount account = players[playerNum];
//        account.deposit(amount);
//    }

    /**
     * Withdraws money from a bank account.
     *
     * @param distance the assigned distance
     */
    public void move(int distance)
    {
        if(randomEvent())
        {
            // Handle it below
        }

        goalDistance -= distance;
    }

    /**
     * Gets the balance of a bank account.
     *
     * @return the account balance
     */
    public void heal() {
        if(randomHealEvent())
        {
            // Handle it below
        }
    }

    public void doNothing()
    {
        if(randomNothingEvent())
        {
            // Handle it below
        }
    }

    void damaged() {
        hp -= 5;
        System.out.println("You took some damage. Remaining HP: " + hp);
    }

    void superdamaged()
    {
        hp -= 10;
        System.out.println("You took a large amount of damage. Remaining HP: " + hp);
    }

    void uberDamaged()
    {
        hp -= hp;
        System.out.println("You just got hit with a rogue fireball. Literally cooked... Remaining HP: " + hp);
    }


    private boolean randomEvent() {
        int min = 1;
        int max = 100;

        Random rand = new Random();
        int randomNumber = rand.nextInt(max - min + 1) + min; // Generates a random number between min and max (inclusive)

        if (randomNumber >= 1 && randomNumber <= 5)
        {
            // Do sizeable damage if number between 1 and 5
            System.out.println("");
            damaged();
        }
        else if ((randomNumber >= 5 && randomNumber <= 20))
        {
            // Do sizeable damage if number between 5 and 20
            superdamaged();
        }
        else if (randomNumber >= 90 && randomNumber <= 100)
        {
            // RIP you got nuked
            uberDamaged();
            // End game aka goes down to if statement below
        }
        else {
            // Any other #
            System.out.println("Looks like things are going your way...");
        }

        if (hp <= 0)
        {
            System.out.println("Game Over! Your HP has reached 0.");
            System.exit(0);
        }

        return true;
    }

    private boolean randomHealEvent() {
        int min = 1;
        int max = 100;

        Random rand = new Random();
        int randomNumber = rand.nextInt(max - min + 1) + min;

        if (randomNumber >= 1 && randomNumber <= 10) {
            // Do something if the random number is between 1 and 10
            hp += 1;
            System.out.println("You got sold a dud elixir, you knew the vendor was shady...");
            System.out.println("Your HP is now : " + hp);
            return true;
        } else if (randomNumber == 100) {
            hp *= 2;
            System.out.println("Holy Shmoley you found an elixir that doubles your health, hope you have a high amount...");
            System.out.println("Your HP is now : " + hp);
            return true;
        } else {
            // Any other number (11-99)
            hp += 5;
            System.out.println("You healed for 5 HP, making your health: " + hp);
            return true;
        }
    }

    private boolean randomNothingEvent() {
        int min = 1;
        int max = 1000;

        Random rand = new Random();
        int randomNumber = rand.nextInt(max - min + 1) + min;

        if (randomNumber >= 1 && randomNumber <= 10) {
            // Small damage if the random number is between 1 and 10
            hp -= 1;
            System.out.println("You stubbed your toe when looking for a place to rest and do nothing...");
            System.out.println("Your HP is now : " + hp);
        } else if (randomNumber == 1000) {
            // Lucky win
            System.out.println("Someone passed by on a carriage and offered you a ride, you made it!");
            // End game...
            System.exit(0);
        } else {
            // Any other number (11-999)
            System.out.println("Nothing happened, I hope you weren't expecting anything...");
        }

        //check if health is 0
        if (hp <= 0)
        {
            System.out.println("Game Over! Your HP reached 0.");
            System.exit(0);
        }

        return true;
    }

    public int getHP()
    {
        return hp;
    }
}

