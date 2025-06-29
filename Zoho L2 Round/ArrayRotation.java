import java.util.*;
public class ArrayRotation{
    public static void rotateArray(int[] array, int k){
        k=k% array.length;
        for(int i=0;i<k;i++){
            int last=array[array.length-1];
            for(int j= array.length-1;j>0;j--){
                array[j]=array[j-1];
            }
            array[0]=last;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] array=new int[n];
        for(int i=0;i<array.length;i++){
            array[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        rotateArray(array, k);

        for(int i: array){
            System.out.print(i+" ");
        }
    }
}