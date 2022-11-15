import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Account_Info
{
    Scanner sc= new Scanner(System.in);

    private static int account_count=0;

    private String name,Pancard;
    protected double balance,limit,t_amount;
    private int age,date,year,month,mobileno;
    private String aadharcard;
    private String accountno;

    private Period period;

    private int ptr=-1;

    private ArrayList<Transaction> taction;

    public Account_Info(){

    }


    public Account_Info(String name, String pancard, int age, int date, int year, int month, int mobileno, String aadharcard,double balance)
    {
        this.name = name;
        this.Pancard = pancard;
        this.age = age;
        this.date = date;
        this.year = year;
        this.month = month;
        this.mobileno = mobileno;
        this.aadharcard = aadharcard;
        this.balance = balance;


        taction = new ArrayList<>();
        taction.add(new Transaction(balance, LocalDateTime.now(),"deposit"));

        limit = 25000;
        t_amount = limit;

        this.accountno =("0000"+ ++account_count);
    }


    public void display() {
        System.out.println("*-----Account Information-----*");
        System.out.println(" Account Number :" + accountno);
        System.out.println(" Your Name is: " + name);
        System.out.println("Your age is : "+age);
        System.out.println(" Date of Birth: " + date + "/" + month + "/" + year);
        System.out.println(" Aadhar card number: " + aadharcard);
        System.out.println(" PAN card number: " + Pancard);
        System.out.println(" Mobile number: " + mobileno);
        System.out.println(" Balance :" + balance);
        System.out.println(" ");
    }

    public void get_balance()
    {
        System.out.println("Balance is "+balance);

    }

    public ArrayList<Transaction> get_taction()
    {
        return taction;
    }

    public void create_transaction(Transaction transaction)
    {
        taction.add(transaction);
    }

    public String getName() {
        return name;
    }

    public static int get_account()
    {
        return account_count;
    }

    public static void add_acc()
    {
        account_count++;
    }

    public void track_amount()
    {
        for(int i=ptr+1; i<taction.size();i++)
        {
            if(LocalDateTime.now().getDayOfYear()==taction.get(i).getLt().getDayOfYear())
            {
                t_amount-=taction.get(i).getAmount();
                ptr++;
            }
        }
    }

}