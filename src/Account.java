public class Account {
    
    private int accountNumber;
    private String accountName;
    private String accountType;
    private double balance;

    public Account(int acnumber, String acname, String actype, double bal) {
        accountNumber = acnumber;
        accountName = acname;
        accountType = actype;
        balance = bal;
    }

    public void increaseBalance(double amount) {
        balance += amount;
    }

    public void decreaseBalance(double amount) {
        balance -= amount;
    }

    

    public void displayAccount()
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public double getBalance() 
    {
        return balance;
    }

    public String getAccountName() 
    {
        return accountName;
    }

    public String getAccountType() 
    {
        return accountType;
    }
}
