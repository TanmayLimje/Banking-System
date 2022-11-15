import java.time.LocalDateTime;
import java.util.*;
import java.time.LocalDate;
import java.time.Period;

public class Bank_database {

    private Account_Info account ;

    public Bank_database(Account_Info account)
    {
        this.account= account;
    }


    public void deposit(double d)
    {
        account.balance= account.balance + d;
        System.out.println("Your A/c is credited by Rs: "+d+" . A/c  balance is Rs: "+account.balance);
        account.create_transaction(new Transaction(d, LocalDateTime.now(),"deposit"));
    }

    public void withdraw(double w)
    {

        if(w<account.balance) {
            account.balance = account.balance - w;
            System.out.println("Your A/c debited by Rs: "+w+" . A/c balance is Rs: "+account.balance);
            account.create_transaction(new Transaction(w, LocalDateTime.now(),"withdrawal"));
            account.track_amount();
        }
        else {
            System.out.println("Insufficient balance");
        }
    }

    public void get_balance()
    {
        account.get_balance();
    }

    public void get_info()
    {
        account.display();
    }

    public void show_tactions()
    {
        Transaction temp;
        for(int i=0;i<account.get_taction().size();i++)
        {
            temp = account.get_taction().get(i);
            System.out.println("----------------------------");
            System.out.println("Amount : "+temp.getAmount());
            System.out.println("Date : "+temp.getLt());
            System.out.println("Type : "+temp.getType());
            System.out.println("----------------------------");
        }

    }

    public void setAccount(Account_Info account) {
        this.account = account;
    }
}
