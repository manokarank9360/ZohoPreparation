
import java.util.*;

class CreditCard{
    String cardHolder;
    long cardNumber;
    double creditLimit;
    double availableBalance;

    public CreditCard(String cardHolder, long cardNumber, double creditLimit){
        this.cardHolder=cardHolder;
        this.cardNumber=cardNumber;
        this.creditLimit=creditLimit;
        this.availableBalance=creditLimit;
    }

    public void makeTransaction(int amount){
        availableBalance-=amount;
    }
    public void addPayment(int amount){
        availableBalance+=amount;
    }
    public String toString(){
        return "CardHolder Name : "+cardHolder+"\nCard Number : "+cardNumber+"\nCredit Limit : "+creditLimit+"\nAvailable Balance : "+availableBalance;
    }
}

class CardManager{
    CreditCard instance;
    Scanner scanner;

    public void setObjects(CreditCard instance, Scanner scanner) {
        this.instance = instance;
        this.scanner=scanner;
    }

    public CreditCard createCard(){
        System.out.println("Enter Card Holder Name : ");
        String name=scanner.next();
        System.out.print("Enter Card Number : ");
        long cardNumber=scanner.nextLong();
        System.out.print("Enter Card Limit : ");
        int creditLimit=scanner.nextInt();
        instance=new CreditCard(name, cardNumber, creditLimit);
        return instance;
    }

    public void viewCard(){
        System.out.println(instance);
    }

    public void makeTransaction(){
        System.out.println("Enter Transaction Amount : ");
        int amount=scanner.nextInt();
        if(amount>instance.availableBalance){
            System.out.println("Insufficient Balance!");
            return;
        }
        instance.makeTransaction(amount);
        System.out.println("Transaction successful! Remaining Balance : "+instance.availableBalance);
    }

    public void payDueAmount(){
        System.out.println("Enter Amount : ");
        int amount=scanner.nextInt();
        if(instance.creditLimit==instance.availableBalance || amount>instance.creditLimit || amount>(instance.creditLimit- instance.availableBalance)){
            System.out.println("Payment not done! Please check balance or credit limit!");
            return;
        }
        instance.addPayment(amount);
        System.out.println("Payment successful!");
    }
}
public class CreditCardSystem {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        CardManager object=new CardManager();
        CreditCard instance=null;
        System.out.println("\n--- Credit Card System ---");
        while (true){
            System.out.println("\n1. Create Card");
            System.out.println("2. View Card");
            System.out.println("3. Make Transaction");
            System.out.println("4. Pay Due Amount");
            System.out.println("5. Exit");

            int choice=scanner.nextInt();

            switch (choice){
                case 1: if(instance==null) {
                        object.setObjects(instance, scanner);
                        instance=object.createCard();
                        }
                        else System.out.println("Card already created!");
                        break;
                case 2: object.viewCard();break;
                case 3: object.makeTransaction();break;
                case 4: object.payDueAmount();break;
                case 5:
                    System.out.println("Thank You!");return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}