public class Main
{
    public static void main(String args[])
    {

        Login login = new Login();
        Account_Info account = null;

        while (account == null)
            account = login.loginInitiator();
        login.Bank_processor(account);


    }
}
