import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class AccountReport 
{
    public void displayAccounts(Account[] accounts, int accountCount)
    {
        for (int i= 0; i<accountCount; i++)
        {
            accounts[i].displayAccount();
            System.out.println("------------------------------------");
        }
    }

    public void generateDbReport(Account[] accounts, int accountCount)
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy-HHmm");
        String timestamp = now.format(formatter);

        String fileName = "reports/database_reports/accounts_database_report_" + timestamp + ".txt";

        try
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            bw.write("==============================\n");
            bw.write("|  ACCOUNTS DATABASE REPORT  |\n");
            bw.write("==============================\n");
            bw.newLine();
            bw.newLine();
            for(int i = 0; i < accountCount; i++)
            {
                Account ac = accounts[i];

                bw.write("Account Number: " + ac.getAccountNumber());
                bw.newLine();

                bw.write("Account Name: " + ac.getAccountName());
                bw.newLine();

                bw.write("Account Type: " + ac.getAccountType());
                bw.newLine();

                bw.write("Balance: " + ac.getBalance());
                bw.newLine();

                bw.newLine();
                bw.write("----------------------------------------");
                bw.newLine();
                bw.newLine();
            }
            bw.write  ("Total Accounts: "+ accountCount);
            bw.newLine();
            bw.write("\n======== END OF REPORT =======");
            bw.newLine();
            bw.close();

            System.out.println("Account database report generated successfully.");
            System.out.println("File: " + fileName);

        }
        catch(IOException e)
        {
            System.out.println("Failed to generate report file, try closing Monolith and restarting.");

        }
    }

    
}
