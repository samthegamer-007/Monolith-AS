public class AccountingEngine
{
    public String getGroup(String accountType)
    {
        if(accountType.equals("Loss") || 
           accountType.equals("Expense") || 
           accountType.equals("Asset") ||
           accountType.equals("Drawing"))
        {
            return "LEAD";
        }

        else if(accountType.equals("Gain") ||
                accountType.equals("Income") ||
                accountType.equals("Reserve") ||
                accountType.equals("Fund") ||
                accountType.equals("Provision") ||
                accountType.equals("Liability"))
        {
            return "GIRL";
        }

        return "INVALID";

    }

    public String getNormalSide(String accountType)
    {
        if(getGroup(accountType).equals("LEAD"))
            return "DEBIT";
        else if(getGroup(accountType).equals("GIRL"))
            return "CREDIT";

        return "INVALID";
    }

    public boolean isValidAccountType(String accountType)
    {
         if(getGroup(accountType).equals("LEAD") || 
            getGroup(accountType).equals("GIRL"))
            return true;
        else
            return false;
    }

    public String getEffect(String accountType, String entryType)
    {
        if(isValidAccountType(accountType))
        {
        if(getGroup(accountType).equals("LEAD") && entryType.equalsIgnoreCase("DEBIT"))
            return "INCREASE";
        else if (getGroup(accountType).equals("LEAD") && entryType.equalsIgnoreCase("CREDIT"))
            return "DECREASE";
        else if (getGroup(accountType).equals("GIRL") && entryType.equalsIgnoreCase("DEBIT"))
            return "DECREASE";
        else if(getGroup(accountType).equals("GIRL") && entryType.equalsIgnoreCase("CREDIT"))
            return "INCREASE";
        }
        return "INVALID";

    }
    
    

}