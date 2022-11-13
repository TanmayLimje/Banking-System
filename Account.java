//basic detail of user
//balance of account
//todays expence ,list of transaction


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Account
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


    public Account(String name, String pancard, int age, int date, int year, int month, int mobileno, String aadharcard,double balance)
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

    public void create() {

        Scanner sc = new Scanner(System.in);

        System.out.println("---Account creation---");

        System.out.println("Please enter your name:");
        name = sc.next();

        boolean result = name.matches("[a-zA-Z]+");
        if(result==true) {
            System.out.println("Valid name");
        } else
            System.out.println("Invalid input");

        System.out.println("Please enter your date of birth:");
        System.out.println("date:");
        date = sc.nextInt();
        System.out.println("month:");
        month = sc.nextInt();
        System.out.println("year:");
        year = sc.nextInt();

        LocalDate dob = LocalDate.of(year,month,date);

        LocalDate curDate = LocalDate.now();

        Period period = Period.between(dob, curDate);

        age=period.getYears();

        System.out.println("Your age is "+period.getYears()+" years "+period.getMonths()+" months and "+period.getDays()+" days." );


        System.out.println("Please enter your PAN card number:");
        Pancard = sc.next();


        do{
            System.out.println("Enter your Aadhar card number: ");
            aadharcard=sc.next();

        }while(aadharcard.length()==12);


        do{
            System.out.println("Enter your mobile number: ");
            mobileno=sc.nextInt();

        }while(mobileno==10);

        System.out.println("Please enter your minimum balance amount to be started with: ");
        balance = sc.nextDouble();

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
