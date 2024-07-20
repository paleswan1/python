/**
 * Class CreditCard is the child class used to represent a real-life credit card
 * 
 * @author(22067699 Kshitiz Shrestha)
 * @version(1.0.0)
 */
public class CreditCard extends BankCard
{
    //Six attribute with private access
    private int CVCnumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;
    
    //Constructor CreditCard created
    public CreditCard(int cardID,String clientName, String issuerBank,String bankAccount,int balanceAmount,int CVCnumber,double interestRate,String expirationDate){
        super(balanceAmount, cardID, bankAccount,issuerBank);//calling the super class
        setClientName(clientName);//calling the setter method from the super class
        //attribute = parameter
        this.CVCnumber = CVCnumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        this.isGranted = false;//setting granted status to be false
    }
    
    //Accessor method for each attribute
    public int getCVCnumber(){
        return this.CVCnumber;
    }
    
    public double getCreditLimit(){
        return this.creditLimit;
    }
    
    public double getInterestRate(){
        return this.interestRate;
    }
    
    public String getExpirationDate(){
        return this.expirationDate;
    }
    
    public int getGracePeriod(){
        return this.gracePeriod;
    }
    
    public boolean getIsGranted(){
        return this.isGranted;
    }
    
    
    /*setter function to set credit limit
     * also, condition imposed to set the values and granted status to true
     */
    public void setCreditLimit(double creditLimit, int gracePeriod){
        if(creditLimit <= (2.5 * getBalanceAmount())){
            this.creditLimit = creditLimit;
            this.gracePeriod = gracePeriod;
            this.isGranted = true;
        }
        else{
            System.out.println("Unable to process request \n The credit cannot be issued.");
            this.isGranted = false;
        }
    }
    
    
    //method to cancel the credit card 
    public void cancelCreditCard(){
        //attributes set to 0 and granted status set to false
        this.CVCnumber = 0;
        this.creditLimit = 0;
        this.gracePeriod = 0;
        this.isGranted = false;
    }
        
    
    //display method to display all details, void as there is no return type
    public void display(){
        /*when condition meets, display method of super class is called along with two attributes printed with suitable annotation
         * if the condition is not met then CVCnumber, interestRate and expirationDate is printed
         */
        if(isGranted == true){
            super.display();
            System.out.println("Credit Limit: " + creditLimit);
            System.out.println("Grace Period: " + gracePeriod);
        }
        else{
            System.out.println("CVC number: " + CVCnumber);
            System.out.println("Interest Rate: " + interestRate);
            System.out.println("Expiration Date: " + expirationDate);
        }
    }
}
