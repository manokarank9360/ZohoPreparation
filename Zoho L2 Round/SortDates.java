import java.util.*;
class   Date{
    int date;
    int month;
    int year;

    public Date(int date, int month,int year){
        this.date=date;
        this.month=month;
        this.year=year;
    }

    public int compareDate(){
        return year*10000 + month*100 + date;
    }

    public void printDate(){
        System.out.printf("%02d %02d %04d\n",date, month, year);
    }
}

public class SortDates {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Date[] dates=new Date[n];

        for(int i=0;i<dates.length;i++){
            int date=sc.nextInt();
            int month=sc.nextInt();
            int year=sc.nextInt();
            dates[i]=new Date(date, month, year);
        }

        for(int i=0;i< dates.length-1;i++){
            for(int j=i+1;j<dates.length;j++){
                if(dates[i].compareDate()>dates[j].compareDate()){
                    Date temp=dates[i];
                    dates[i]=dates[j];
                    dates[j]=temp;
                }
            }
        }

        for(Date i:dates){
            i.printDate();
        }
    }
}