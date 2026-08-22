import java.util.Scanner;
public class AccountingSystem {
private  Scanner ab =  new Scanner(System.in);


 private Account[] accounts = new Account[1000];
 private int accountCount = 0;

 private AccountStorage storage = new AccountStorage();

 private AccountReport accountReport = new AccountReport();

 public void start()
 {
    // Implementation of the accounting system's main functionality goes here

    accountCount = storage.loadAccounts(accounts);

    int ch=-1, insNum=1;
    while(ch != 0) // 0 is the exit option, do not change it
      {
         System.out.println("Instance: "+ insNum);
         System.out.println("======== MAIN MENU ========");
         System.out.println("|                         |");
         System.out.println("|1. Create Account        |");
         System.out.println("|2. Find Account          |");
         System.out.println("|3. Delete Account        |");
         System.out.println("|4. See All Accounts      |");
         System.out.println("|0. Exit                  |");
         System.out.println("|=========================|");
         System.out.println("Select an option: ");
         ch = ab.nextInt();
        

        
        switch (ch) 
        {
                case 1: createAccount();
                        insNum++;
                        break;

                case 2: searchAccount();
                        insNum++;
                        break;

                case 3: deleteAccountMenu();
                        insNum++;
                        break;

                case 4: int subch = -1;
                        while (subch !=0)
                        {
                           System.out.println("======== ACCOUNT DATABASE ========");
                           System.out.println("|                                |");
                           System.out.println("|1. View All Accounts Here       |");
                           System.out.println("|2. Download Report File         |");
                           System.out.println("|0. Back to Main Menu            |");
                           System.out.println("|================================|");
                           System.out.println("Select an option:");
                           subch = ab.nextInt();

                           switch(subch)
                           {
                              case 1: accountReport.displayAccounts(accounts, accountCount);
                              break;

                              case 2: accountReport.generateDbReport(accounts, accountCount);
                              break;

                              case 0: 
                              break;

                              default: System.out.println("Invalid choice...");
                              break;
                           }
                        }
                        insNum++;
                        break;

                case 0: System.out.println("Exiting the system. Goodbye!");
                        break;
        
                default: System.out.println("Invalid choice. Please try again.");
                        break;
        }
      }
      ab.close();
        
 }

 public Account findAccount( int accountNumber)
 {
   for (int i = 0; i < accountCount; i++)
   {
      if (accounts[i].getAccountNumber() == accountNumber)
      {
         return accounts[i];

      }
   }
   return null;
 } 

 public Account createAccount()
 {
   System.out.print("Enter account number: ");
   int accountNumber = ab.nextInt();

   if( findAccount(accountNumber) != null)
   {
      System.out.println("Account already exists.");
      return null;
   }
   else 
   {
      System.out.println("Enter account name:");
      ab.nextLine(); // Consume the newline character
      String accountName = ab.nextLine().trim();
      System.out.println("Enter account type:");
      String accountType = ab.nextLine().trim();
      System.out.println("Enter opening balance:");
      double openingBalance = ab.nextDouble();
      Account newAccount = new Account(accountNumber, accountName, accountType, openingBalance);
      accounts[accountCount] = newAccount;
      accountCount++;
      storage.saveAccounts(accounts, accountCount);
      System.out.println("Account created successfully.");
      return newAccount;


   }
 }

 public int deleteAccount(int accountNumber)
 { 
   for (int i = 0; i< accountCount; i++)
   {
      if (accounts[i].getAccountNumber() == accountNumber)
      {
         for (int j = i; j< accountCount -1; j++)
         {
            accounts[j] = accounts[j+1]; 
         }
         accounts[accountCount -1] = null; // Clear the last account reference
         accountCount--;
         storage.saveAccounts(accounts, accountCount);
         return 1; //(1 means account deleted)
      }
   }
   return 0; //(0 means account not found)

 }

 public void searchAccount()
{
    System.out.print("Enter account number: ");
    int acnumfinder = ab.nextInt();

    Account foundAccount = findAccount(acnumfinder);

    if(foundAccount != null)
    {
        foundAccount.displayAccount();
    }
    else
    {
        System.out.println("Account not found.");
    }
}

public void deleteAccountMenu()
{
    System.out.print("Enter account number to delete: ");
    int acnumdeleter = ab.nextInt();

    int delRes = deleteAccount(acnumdeleter);

    if(delRes == 1)
    {
        System.out.println("Account deleted successfully.");
    }
    else
    {
        System.out.println("Account not found.");
    }
}




}       
  

