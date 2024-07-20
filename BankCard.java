
/**
 * Class BankCard is the parent class providing information on the bank account of the individual
 * 
 * @author(22067699 Kshitiz Shrestha)
 * @version(1.0.0)
 */
public class BankCard
{
    //Five attributes with private access
    private String bankAccount;
    private int cardID;
    private int balanceAmount;
    private String clientName;
    private String issuerBank;
    
    
    //Constructor BankCard created
    public BankCard(int balanceAmount,int cardID,String bankAccount, String issuerBank){
        //assigning values passed as parameters
        //attributes = parameters
        this.balanceAmount = balanceAmount;
        this.cardID = cardID;
        this.bankAccount = bankAccount;
        this.issuerBank = issuerBank;
        this.clientName = "";//client name intialized as an empty string
    }
    
    
    //Accessor method for each attribute i.e; getter
    public int getBalanceAmount(){
        return this.balanceAmount;
    }
    
    public int getCardID(){
        return this.cardID;
    }
    
    public String getBankAccount(){
        return this.bankAccount;
    }
    
    public String getIssuerBank(){
        return this.issuerBank;
    }
    
    public String getClientName(){
        return this.clientName;
    }
    
    
    //method to set the client's name
    public void setClientName(String clientName){
        //attribute = parameter
        this.clientName = clientName;
    }
    
    //method to set the balance amount
    public void setBalanceAmount(int balanceAmount){
        //attribute = parameter
        this.balanceAmount = balanceAmount;
    }
    
    //display method to display all details, void as there is no return type
    public void display(){
        // a condition to check whether the client name is equal to empty string or not
        if(clientName.equals("")){
            System.out.println("ALERT!");
            System.out.println("No name specified.");
        }
        else{
            System.out.println("Client Name: " + clientName);
        }
        System.out.println("Card Id: " + cardID);
        System.out.println("Issuer Bank: " + issuerBank);
        System.out.println("Bank Account: " + bankAccount);
        System.out.println("Balance Amount: " + balanceAmount);
    }
    
}
