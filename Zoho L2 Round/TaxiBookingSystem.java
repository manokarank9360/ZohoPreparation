import java.util.*;

class Taxi{
    int taxiId;
    char currentPoint='A';
    int totalEarnings=0;
    boolean availability=true;
    ArrayList<Booking> bookings=new ArrayList<>();

    public Taxi(int id){
        this.taxiId=id;
    }

    public boolean isAvailability(int requestTime) {
        if(bookings.isEmpty()) return true;
        Booking lastBooking=bookings.get(bookings.size()-1);
        return lastBooking.dropTime<=requestTime;
    }

    public int calculateEarnings(char from, char to){
        int distance=Math.abs(to-from)*15;
        return 100+Math.max(0,(distance-5)*10);
    }

    public void addBooking(Booking booking){
        bookings.add(booking);
        totalEarnings+=booking.amount;
        currentPoint=booking.to;
    }

}

class Booking{
    int bookingId, customerId, pickupTime, dropTime, amount;
    char from, to;

    public Booking(int bookingId, int customerId, char from, char to, int pickupTime, int dropTime, int amount){
        this.bookingId=bookingId;
        this.customerId=customerId;
        this.from=from;
        this.to=to;
        this.pickupTime=pickupTime;
        this.dropTime=dropTime;
        this.amount=amount;
    }
}

class TaxiManager{
    int customerId=101;
    ArrayList<Taxi> taxis=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);

    public void initializeTaxis(int numOfTaxis){
        for(int i=1;i<=numOfTaxis;i++){
            taxis.add(new Taxi(i));
        }
    }
    public void bookTaxi(){
        System.out.println("Enter Pick-up Point(A-F) : ");
        char pickup=scanner.next().charAt(0);
        System.out.println("Enter Drop Point(A-F) : ");
        char drop=scanner.next().charAt(0);
        System.out.println("Enter Pick-up Time(Hours) : ");
        int pickupTime=scanner.nextInt();

        Taxi selectedTaxi=null;
        int minDistance=Integer.MAX_VALUE;

        for(Taxi taxi: taxis){
            if(taxi.isAvailability(pickupTime)){
                int distance=Math.abs(taxi.currentPoint-pickup);
                if(distance<minDistance || (distance==minDistance && taxi.totalEarnings<selectedTaxi.totalEarnings)){
                    selectedTaxi=taxi;
                    minDistance=distance;
                }
            }
        }
        if(selectedTaxi==null){
            System.out.println("Booking Rejected! No taxis available!");
            return;
        }

        int dropTime=pickupTime+Math.abs(drop-pickup);
        int amount=selectedTaxi.calculateEarnings(pickup, drop);
        int bookingId= selectedTaxi.bookings.size()+1;

        selectedTaxi.addBooking(new Booking(bookingId, customerId, pickup, drop, pickupTime, dropTime, amount));
        System.out.println("Taxi "+selectedTaxi.taxiId+" is allocated.");
    }

    public void taxiDetails(){
        for (Taxi taxi:taxis){
            System.out.println("Taxi-"+taxi.taxiId+" Total Earnings : Rs. "+taxi.totalEarnings);
            for (Booking booking: taxi.bookings){
                System.out.println("Booking ID : "+booking.bookingId+" Customer ID : "+booking.customerId+" Pick-Up : "+booking.from+ " Drop : "+booking.to+" Pick-Up Time : "+ booking.pickupTime+" Drop Time : "+booking.dropTime);
            }
            System.out.println();
        }
    }
}

public class TaxiBookingSystem {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        TaxiManager instance=new TaxiManager();
        System.out.println("Enter number of taxis: ");
        int numTaxis=scanner.nextInt();
        instance.initializeTaxis(numTaxis);

        while (true){
            System.out.println("1. Book taxi");
            System.out.println("2. View taxi details");
            System.out.println("3. Exit");
            int choice=scanner.nextInt();

            switch (choice){
                case 1:
                    instance.bookTaxi();
                    break;
                case 2:
                    instance.taxiDetails();
                    break;
                case 3:
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}