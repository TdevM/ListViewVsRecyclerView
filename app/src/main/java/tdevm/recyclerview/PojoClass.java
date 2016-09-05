package tdevm.recyclerview;

import java.util.ArrayList;

/**
 * Created by Tridev on 23-08-2016.
 */
public class PojoClass {

    public static class Accounts{
        String fName;
        String lName;
        double balance;
        String currency;
        String balDate;
        String branch;


        public Accounts(String fName, String lName, double balance, String currency, String balDate, String branch) {
            this.fName = fName;
            this.lName = lName;
            this.balance = balance;
            this.currency = currency;
            this.balDate = balDate;
            this.branch = branch;
        }

    }

    public static ArrayList<Accounts> getHolders(){
        ArrayList<Accounts> holders = new ArrayList<>(100);
        for(int i=0;i<10;i++) {
            holders.add(new Accounts("Ramesh", "Kumar", 300000.05, "INR", "23-08-2016", "Andheri.W"));
            holders.add(new Accounts("Puneet", "Sahni", 40020.90, "INR", "21-08-2016", "Ghatkoper.E"));
            holders.add(new Accounts("Chandan", "Shah", 30002.34, "INR", "21-08-2016", "Kandiwali.E"));
            holders.add(new Accounts("Sonali", "Jadli", 50030.50, "INR", "21-08-2016", "Mira Road"));
            holders.add(new Accounts("Rajat", "Giri", 505005.05, "INR", "13-08-2016", "Film City"));
            holders.add(new Accounts("Gurjant", "Singh", 300.00, "INR", "21-08-2016", "Mulund.W"));
            holders.add(new Accounts("Poonam", "Gupta", 40000.00, "INR", "23-08-2016", "Andheri.W"));
            holders.add(new Accounts("Ravi", "Kumar", 80000.00, "INR", "21-08-2016", "Andheri.E"));
            holders.add(new Accounts("Neelam", "Deelima", 84000.25, "INR", "20-08-2016", "Branchtest"));
            holders.add(new Accounts("Ramesh", "Sippy", 300000.5, "INR", "23-08-2016", "Andheri.W"));
        }
        return holders;
    }
}
