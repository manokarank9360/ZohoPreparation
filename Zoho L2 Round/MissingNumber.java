import java.util.*;
public class MissingNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),sum1=0,sum2=0;
        int[] array=new int[n-1];
        for(int i=0;i<array.length;i++){
            array[i]=sc.nextInt();
        }
        for(int i:array){
            sum1=sum1^array[i];
            sum2=sum2^n--;
        }
        sum2=sum2^n;
        System.out.println(sum1^sum2);
    }
}

/*

Problem 1: Find the Missing Number
You are given an array of size n-1 that contains distinct integers from 1 to n. Find the missing number without using inbuilt methods.

Input: [1, 2, 4, 6, 3, 7, 8]
Output: 5

*/