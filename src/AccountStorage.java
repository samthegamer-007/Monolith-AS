import java.io.*;
public class AccountStorage //This class is responsible for storing and retrieving account data from "accounts.txt" file in "data" folder.
{
    public void saveAccounts(Account[] accounts, int accountCount)
    {
        try
        {
            BufferedWriter bw = new BufferedWriter (new FileWriter ("data/accounts.txt"));
            for (int i = 0; i< accountCount; i++)
            {
                Account ac = accounts[i];
                bw.write(ac.getAccountNumber() + "|" + ac.getAccountName() + "|" + ac.getAccountType() + "|" + ac.getBalance());
                bw.newLine();
            }
            bw.close();
        }
        catch (IOException e)
        {
            System.out.println("Error occurred while saving accounts Try closing Monolith and restarting.");
        }
    }

    public int loadAccounts(Account[] accounts)
    {
        try
        {
            BufferedReader br = new BufferedReader (new FileReader ("data/accounts.txt"));
            String line;
            int count = 0;
            while((line = br.readLine()) != null)
            {
                String[] data = line.split("\\|");
                int accountNumber = Integer.parseInt(data[0]);
                String accountName = data[1];
                String accountType = data[2];
                double balance = Double.parseDouble(data[3]);
                Account ac = new Account(accountNumber, accountName, accountType, balance);
                accounts[count] = ac;
                count++;
            }
            br.close();
            return count;
        }
        catch (IOException e)
        {
            System.out.println("Error occurred while loading accounts. Try closing Monolith and restarting.");
            return 0;
        }
        
    }

    
}



