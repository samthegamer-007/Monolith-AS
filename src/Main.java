
public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("|      MONOLITH ACCOUNTING SYSTEM      |"); 
        System.out.println("========================================");
        System.out.println("By Sambit Gope (https://github.com/samthegamer-007)");

        FileManager fm = new FileManager();
        fm.prepareData();

        AccountingSystem system = new AccountingSystem();
        system.start();
        
        
        
    }
} 