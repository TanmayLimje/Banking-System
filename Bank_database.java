
import java.util.*;

public class Bank_database {

    Scanner sc= new Scanner(System.in);

    private static int account_count;
    private String name;
    protected double balance;
    private int age;
    private int date;
    private int month;
    private int year;
    private String Pancard;
    private int aadharcard;
    private String accountno[] = new String[7];
    private int mobileno;

    public void create() {

        Scanner sc = new Scanner(System.in);

        System.out.println("---Account creation---");

        System.out.println("Please enter your name:");
        name = sc.next();

        System.out.println("Please enter your age:");
        age = sc.nextInt();

        System.out.println("Please enter your date of birth:");
        System.out.println("date:");
        date = sc.nextInt();
        System.out.println("month:");
        month = sc.nextInt();
        System.out.println("year:");
        year = sc.nextInt();


        System.out.println("Please enter your PAN card number:");
        Pancard = sc.next();

        System.out.println("Please enter your Aadhar card number:");
        aadharcard = sc.nextInt();

        System.out.println("Please enter your Mobile number: ");
        mobileno = sc.nextInt();

        System.out.println("Please enter your minimum balance amount to be started with: ");
        balance = sc.nextDouble();


        System.out.println("**DATABASE UPDATED**");

    }

    public void account_no_generator() {

        Random ac = new Random();

        int a;

        for (int i = 0; i < 7; i++) {
            a = ac.nextInt(7);
            accountno[i] = Integer.toString(a);
        }
        System.out.println("Newly generated account number is: ");
        for(int i = 0; i < 7; i++) {
            System.out.print(accountno[i]);

        }

    }

    public void display() {
        System.out.println("*-----Account Information-----*");
        get_accno();
        System.out.println(" Your Name is: " + name);
        System.out.println(" Your age is: " + age);
        System.out.println(" Date of Birth: " + date + "/" + month + "/" + year);
        System.out.println(" Aadhar card number: " + aadharcard);
        System.out.println(" PAN card number: " + Pancard);
        System.out.println(" Mobile number: " + mobileno);
        System.out.println(" Balance :" + balance);
        System.out.println("  ");
    }

    public void get_balance()
    {
        System.out.println("Balance is "+balance);
        System.out.println(" ");

    }

    public void deposit(double d)
    {
        this.balance= this.balance + d;
        System.out.println("Your A/c is credited by Rs: "+d+" . A/c credit balance is Rs: "+balance);
        System.out.println(" ");

    }

    public void withdraw(double w)
    {

        if(w<balance) {
            this.balance = this.balance - w;
            System.out.println("Your A/c deposited by Rs: "+w+" . A/c credit balance is Rs: "+balance);
            System.out.println(" ");
        }
        else {
            System.out.println("Insufficient balance");
            System.out.println(" ");
        }
    }

    public void get_accno()

    {
        for (int i = 0; i < 7; i++) {
            System.out.print(accountno[i]);
        }
    }

    public static int get_account()
    {
        return account_count;
    }

    public static void add_acc()
    {
        account_count++;
    }

    public String get_name(){
        return  name;
    }


}
