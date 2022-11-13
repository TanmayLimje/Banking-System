import java.util.*;

public class Main
{
    public static void main(String args[])
    {
        Account account = new Account("Anya","1234567890",19,15,2003,9,1234567890,"123456789012",1000);
        Bank_database bd= new Bank_database(account);
        bd.withdraw(20);
        bd.get_info();
        bd.deposit(20);
        bd.get_info();
        bd.show_tactions();



    }
}
