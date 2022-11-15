//runapp

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    Account_Info account;
    private ArrayList<Account_Info> accounts;
    private static Scanner sc = new Scanner(System.in);

    Login() {
        accounts = new ArrayList<>();
        accounts.add(new Account_Info("Anya", "1234567890", 19, 15, 2003, 9, 1234567890, "123456789012", 1000));

    }

    public Account_Info loginInitiator() {
        int input;
        Scanner sc = new Scanner(System.in);
        Account_Info temp = null;

        System.out.println("1. Create a New Account");
        System.out.println("2. Log into Existing Account");
        System.out.println("3. Exit");
        System.out.print("Enter your choice:");
        input = sc.nextInt();
        switch (input)
            {

                case 1:
                    temp = create();
                    break;

                case 2:
                    temp = search_acc();
                    break;

            }

        return temp;

        }





    public Account_Info search_acc()
    {
        String name;

        System.out.println("Enter name:");
        name = sc.nextLine();
        System.out.println(" ");

        Account_Info temp = null;

        for(int i = 0; i < accounts.size(); i++)
        {
            if (name.toLowerCase().equals(accounts.get(i).getName().toLowerCase()))
            {
                boolean result = true;
                System.out.println("---Account found ---");
                temp = accounts.get(i); //kahatam tata bye bye

            }

            else
            {
                System.out.println("Sorry no account found with such name.");
                temp = null;
            }

        }

        return temp;
    }

    public Account_Info create()
    {


        String name,Pancard;
        double balance,limit,t_amount;
        int age,date,year,month,mobileno;
        String aadharcard;
        String accountno;

        Scanner sc = new Scanner(System.in);

        System.out.println("---Account creation---");

        System.out.println("Please enter your name:");
        name = sc.nextLine();
        System.out.println();

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

        Account_Info info = new Account_Info(name,Pancard,age,date,year,month,mobileno,aadharcard,balance);


        accounts.add(info);

        return info;


    }


    public void Bank_processor(Account_Info AC)
    {
        int input;
        double amount;
        Bank_database B;

        if(AC != null) {
            B = new Bank_database(AC);

            do{

                System.out.println("Welcome ");
                System.out.println("****************************************");
                System.out.println("1. Show balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Show account information");
                System.out.println("5. Show Transactions");
                System.out.println("6. Log out");
                System.out.println("****************************************");
                System.out.println("Enter your choice:");
                input = sc.nextInt();

                switch (input)
                {
                    case 1:
                        B.get_balance();
                        break;

                    case 2:
                        System.out.println("Enter amount to be deposited:");
                        amount = sc.nextDouble();
                        B.deposit(amount);
                        break;

                    case 3:
                        System.out.println("Enter amount for Withdrawal:");
                        amount = sc.nextDouble();
                        B.withdraw(amount);
                        break;

                    case 4:
                        B.get_info();
                        break;

                    case 5:
                        B.show_tactions();
                        break;

                    case 6:
                        AC = loginInitiator();
                        if(!(AC == null))
                            B.setAccount(AC);
                        else
                            input = 6;
                        break;
                }



            }while(input != 6);

        }

    }

}
