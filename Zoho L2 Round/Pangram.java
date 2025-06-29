import java.util.*;
public class Pangram{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine().toLowerCase();
        int[] array=new int[26];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' ' && (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')){
                array[s.charAt(i)-'a']++;
            }
        }
        for(int i:array){
            if(i==0){
                System.out.print(false);
                return;
            }
        }
        System.out.print(true);
    }
}


/*
Problem:
Check if a given string is a pangram (contains every alphabet at least once, a–z).
        👉 Input: "The quick brown fox jumps over the lazy dog"
        👉 Output: true


For Optimal version using Collections:

Set<Character> set = new HashSet<>();
for (char ch : s.toLowerCase().toCharArray()) {
    if (ch >= 'a' && ch <= 'z') set.add(ch);
}
System.out.println(set.size() == 26);


 */