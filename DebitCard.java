

/**
 * Class DebitCard is the child class used to represent a real-life debit card
 *
 * @author(22067699 Kshitiz Shrestha)
 * @version(1.0.0)
 */
public class DebitCard extends BankCard {
    //Four attributes with private access
    private int PINnumber;
    private int withdrawalAmount;
    private String dateOfWithdrawal;
    private boolean hasWithdrawn;

    //Constructor DebitCard created
    public DebitCard(int balanceAmount, int cardID, String bankAccount, String issuerBank, String clientName, int PINnumber) {
        super(balanceAmount, cardID, bankAccount, issuerBank);//calling the super class
        setClientName(clientName);//calling the setter method in super class
        //attribute = parameter
        this.PINnumber = PINnumber;
        this.hasWithdrawn = false;
    }

    //Accessor method for each attribute
    public int getPINnumber() {
        return this.PINnumber;
    }

    public int getWithdrawalAmount() {
        return this.withdrawalAmount;
    }

    public String getDateOfWithdrawal() {
        return this.dateOfWithdrawal;
    }

    public boolean getHasWithdrawn() {
        return this.hasWithdrawn;
    }


    //mutator method i.e. setter to set the withdrawal amount
    public void setWithdrawalAmount(int withdrawalAmount) {
        //setting the withdrawal amount i.e. attribute = parameter
        this.withdrawalAmount = withdrawalAmount;
    }

    //Withdraw method to  reduce the withdrawal amount from balance
    public void Withdraw(int withdrawalAmount, String dateOfWithdrawal, int PINnumber) {
        this.dateOfWithdrawal = dateOfWithdrawal;
        this.withdrawalAmount = withdrawalAmount;
        //checking PIN validity and sufficient balance to withdraw amount and reduction from main balance
        if (this.PINnumber == PINnumber && getBalanceAmount() > withdrawalAmount) {
            //calling the setter method to set the withdrawalAmount
            setWithdrawalAmount(withdrawalAmount);
            this.hasWithdrawn = true;// indicating successful withdrawal
            int new_balance = getBalanceAmount();
            //balance reduced if amount is withdrawn
            new_balance -= withdrawalAmount;
            //new calculated balance is set as the original balance
            setBalanceAmount(new_balance);
        } else if (this.PINnumber != PINnumber) {
            System.out.println("Invalid PIN number.");
            this.hasWithdrawn = false;
        } else if (withdrawalAmount >= getBalanceAmount()) {
            System.out.println("Insufficient Balance");
            System.out.println("Amount cannot be withdrawn");
            this.hasWithdrawn = false;
        } else {
            System.out.println("Criteria not fulfilled.");
        }
    }


    //display method to display all details, void as there is no return type
    public void display() {
        /*when condition meets, just print the original balance amount
         *when condition does not meet, call the display method from the super class and print remaining attributes
         */
        super.display();
        if (hasWithdrawn == false) {
            System.out.println("===============================");
            System.out.println("Your Balance Amount is: " + getBalanceAmount());
        } else {
            System.out.println("===============================");
            System.out.println("PIN number: " + PINnumber);
            System.out.println("Withdrawal Amount: " + withdrawalAmount);
            System.out.println("Date of Withdrawal: " + dateOfWithdrawal);
        }
    }
}
