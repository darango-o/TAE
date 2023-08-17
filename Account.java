public class Account {
    private final int account_number;
    private final String opening_date;
    private double balance;

    public Account(int acc_num, String open_date, double balance){
        this.account_number = acc_num;
        this.opening_date = open_date;
        this.balance = balance;
    }

    public void addBalance(double quantity){
        this.balance = this.balance + quantity;
    }

    public double withdrawBalance(double quantity){
        if (quantity>this.balance){
            quantity = this.balance;
            this.balance = 0;
            return quantity;
        }

        this.balance = this.balance - quantity;
        return quantity;
    }

    public int getAccount_number() {
        return account_number;
    }

    public String getOpening_date() {
        return opening_date;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
