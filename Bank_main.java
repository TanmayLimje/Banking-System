import java.util.*;

public class Main {

//    public static void search_name(int n, Bank_database db[]) {
//
//        for (int i = 0; i < Bank_database.get_account(); i++) {
//            if (db[i].get_accno() == n) {
//                System.out.println(i + db[i].get_name());
//
//            }
//
//
//        }
//    }


    public static void main(String[] args) {

        Bank_database bd[] = new Bank_database[5];

//       private static int s(String n){
//            for (int i = 0; i < Bank_database.get_account();i++){
//                if (bd[i].get_name() == n)
//                    return i;
//
//            }




        int input;
        Scanner sc= new Scanner(System.in);
        do{


            System.out.println("\n*-----Welcome to New bank-----*");
            System.out.println("1. Create a new account");
            System.out.println("2. Login into existing account");
            System.out.println("3. Deposit or withdraw money ");
            System.out.println("4. Check balance ");
            System.out.println("5. Show account information");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");

            input= sc.nextInt();

            switch(input)
            {
                case 1:
                    bd[Bank_database.get_account()].add_acc();
                    bd[Bank_database.get_account()]=new Bank_database();
                    bd[Bank_database.get_account()].create();
                    bd[Bank_database.get_account()].account_no_generator();
                    break;

                case 2:
//                    System.out.println("Enter A/c number:");
//                    int ac = sc.nextInt();
//                    search_name(ac, bd);

                    break;

                case 3:
                    System.out.println("1. Withdraw");
                    System.out.println("2. Deposit");
                    System.out.println("3. Exit");
                    System.out.println("Enter your choice");
                    int input2= sc.nextInt();
                    switch(input2)
                    {
                        case 1:
                            System.out.println("Enter the amount for withdrawl: ");
                            double w= sc.nextDouble();
                            bd[Bank_database.get_account()].withdraw(w);
                            break;

                        case 2:
                            System.out.println("Enter the amount for deposit: ");
                            double d= sc.nextDouble();
                            bd[Bank_database.get_account()].deposit(d);

                            break;
                    }break;

                case 4:
                    bd[Bank_database.get_account()].get_balance();
                    break;

                case 5:
                    for(int i=1;i<Bank_database.get_account()+1;i++)
                    {
                        bd[i].display();
                    }
                    break;

            }

        }while(input!=6);
    }




}
