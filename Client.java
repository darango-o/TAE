public class Client {
    private final Account account;
    private final String user_name;
    private final String password;

    public Client(Account account, String user_name, String password){
        this.account = account;
        this.user_name = user_name;
        this.password = password;
    }

    public void depositMoney(double quantity, String password){
        if(this.password.equals(password)){
            this.account.addBalance(quantity);
        }
    }

    public double withdrawMoney(double quantity, String password){
        if(!this.password.equals(password)){
            return 0;
        }

        return this.account.withdrawBalance(quantity);
    }

    public Account getAccount() {
        return account;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getPassword() {
        return password;
    }
}
