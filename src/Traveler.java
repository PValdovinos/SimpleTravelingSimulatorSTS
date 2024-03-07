public class Traveler
{
    private TravelerAccount[] players;

    /**
     Constructs a bank account with a given number of accounts.
     @param size the number of accounts
     */
    public Traveler(int size)
    {
        players = new TravelerAccount[size];
        for (int i = 0; i < players.length; i++)
        {
            players[i] = new TravelerAccount();
        }
    }

    /**
     Deposits money into a bank account.
     @param playerNum the player number
     @param amount the amount to deposit
     */
    public void journey(int playerNum, double amount)
    {
        BankAccount account = players[accountNumber];
        account.deposit(amount);
    }

    /**
     Withdraws money from a bank account.
     @param accountNumber the account number
     @param amount the amount to withdraw
     */
    public void withdraw(int accountNumber, double amount)
    {
        BankAccount account = accounts[accountNumber];
        account.withdraw(amount);
    }

    /**
     Gets the balance of a bank account.
     @param accountNumber the account number
     @return the account balance
     */
    public double getBalance(int accountNumber)
    {
        BankAccount account = accounts[accountNumber];
        return account.getBalance();
    }
}
