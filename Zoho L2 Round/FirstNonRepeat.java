import java.util.*;
public class FirstNonRepeat{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] array=new int[n];
        for(int i=0;i<n;array[i++]=sc.nextInt());
        for(int i=0;i<array.length;i++){
            int count=0;
            for(int j=0;j<array.length;j++){
                if(array[i]==array[j] && i!=j){
                    count++;
                }
            }
            if(count==0){
                System.out.print(array[i]);
                return;
            }
        }
        System.out.println("No non-repeating elements");
    }
}

/*
Given an array of integers, return the first non-repeating element.
        👉 Input: [9, 4, 9, 6, 7, 4]
        👉 Output: 6
        ❗ Try both brute force and HashMap approaches.


 Using HashMap:

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>(); // maintains order
        for(int num : array){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println(entry.getKey());
                return;
            }
        }

 */