import java.util.*;
public class TwoSum {
    public static void twoSum(int[] array, int target){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j< array.length;j++){
                if(array[i]+array[j]==target){
                    System.out.print(i+" "+j);
                    return;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=scanner.nextInt();
        }
        int target=scanner.nextInt();
        twoSum(array, target);
    }
}