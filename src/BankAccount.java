public class BankAccount {

/**
 * @param args
 */
int accountNumber;
double accountBalance;

public synchronized boolean Deposit(double amount){
    double newAccountBalance=0;
    if(amount<=0){
        return false;
    }
    else {
        newAccountBalance = accountBalance+amount;
        accountBalance=newAccountBalance;
        return true;
    }

}
public synchronized boolean Withdraw(double amount){
    double newAccountBalance=0;
    if(amount>accountBalance){
        return false;
    }
    else{
        newAccountBalance = accountBalance-amount;
        accountBalance=newAccountBalance;
        return true;
    }
}

public static void main(String[] args) {
    // TODO Auto-generated method stub
    BankAccount b = new BankAccount();
    b.accountBalance=2000;
    System.out.println(b.Withdraw(3000));

}
}