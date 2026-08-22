import java.io.*;
public class FileManager {
    int initStatus = 0;
    
    public void prepareData()
    {
        File reportsFolder = new File("reports");
        File databaseReportsFolder = new File("reports/database_reports");
        File DataFolder = new File("data");
        File accountsFile = new File("data/accounts.txt");
        File transactionsFile = new File("data/transactions.txt");

        try
        {
            if(!reportsFolder.exists())
            {
                reportsFolder.mkdirs();                
                initStatus++;
            }
            else
            {       
                initStatus+=2;
            }
            if(!databaseReportsFolder.exists())
            {
                databaseReportsFolder.mkdirs();                
                initStatus++;
            }
            else
            {       
                initStatus+=2;
            }
            if(!DataFolder.exists())
            {
                DataFolder.mkdirs();                
                initStatus++;
            }
            else
            {       
                initStatus+=2;
            }
            if(!accountsFile.exists())
            {
                accountsFile.createNewFile();               
                initStatus++;
            }
            else
            {               
                initStatus+=2;
            }
            if(!transactionsFile.exists())
            {
                transactionsFile.createNewFile();               
                initStatus++;
            }
            else
            {                
                initStatus+=2;
            }
            if(initStatus == 5 || initStatus == 10)
            {
                System.out.println("Initialising... Please wait. \nChecking data files... \nChecking source files... \nSystem validation completed... Initialisation successful...... \nWELCOME TO MONOLITH ACCOUNTING SYSTEM.");
            }
        }
        catch(IOException e)
        {
            System.out.println("Failed to initialise data files.");

        }

    }
}
