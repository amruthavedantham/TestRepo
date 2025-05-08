import java.util.*;

class BankCustomer {
    private int acc_no;
    private String name;
    private float balance;

    BankCustomer(int acc_no, String name, float balance) {
        this.acc_no = acc_no;
        this.name = name;
        this.balance = balance;
        System.out.println("New Account Created with amount " + balance);
    }

    public int getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(int acc_no) {
        this.acc_no = acc_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String toString() {
        return "acc_no: " + acc_no + " Name: " + name + " Balance: " + balance;
    }

    void deposit(int amt) {
        balance += amt;
        System.out.println("Total: " + balance);
    }

    void withdraw(int amt) {
        if (amt > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amt;
            System.out.println("After withdrawal balance is: " + balance);
        }
    }

    void balanceEnquiry() {
        System.out.println("Balance: " + balance);
    }
}

public class BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Account Number: ");
        int acc_no = sc.nextInt();

        System.out.println("Enter Account Holder's name: ");
        sc.nextLine(); // consume leftover newline
        String name = sc.nextLine();

        System.out.println("Enter the Amount: ");
        float balance = sc.nextFloat();

        BankCustomer obj = new BankCustomer(acc_no, name, balance);

        while (true) {
            System.out.println("\nMenu");
            System.out.println("---->");
            System.out.println("1. Deposit");
            System.out.println("2. Withdrawal");
            System.out.println("3. Enquire Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your Choice: ");

            int option = sc.nextInt();
            int amt;

            switch (option) {
                case 1:
                    System.out.println("Enter amount to deposit: ");
                    amt = sc.nextInt();
                    obj.deposit(amt);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw: ");
                    amt = sc.nextInt();
                    obj.withdraw(amt);
                    break;
                case 3:
                    obj.balanceEnquiry();
                    break;
                case 4:
                    System.out.println("Thank you for using the Bank App.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Enter a valid number");
            }
        }
    }
}
