import java.util.*;
public class ReverseArray{
    public static void reverse(int[] array){
        int left=0, right= array.length-1;
        while(left<right){
            int temp=array[left];
            array[left]=array[right];
            array[right]=temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]= scanner.nextInt();
        }
        reverse(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
}