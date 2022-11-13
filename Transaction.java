import java.time.LocalDateTime;

public class Transaction
{
    private double amount;
    private LocalDateTime lt;
    private String type;

    public Transaction(double amount, LocalDateTime lt,String type)
    {
        this.amount=amount;
        this.lt= lt;
        this.type=type;

    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getLt() {
        return lt;
    }

    public String getType() {
        return type;
    }
}
