import java.util.*;

public class Main {
    public static String solve(String str) {
        class Palindrome {
            static boolean check(String s) {
                if (s.isEmpty())return true;
                int i = 0;
                int j =s.length() -1;
                while (i < j)
                {
                    if (s.charAt(i)!=s.charAt(j)) return false;
                    i++;
                    j--;
                }
                return true;
            }
        }

        class Remove
        { static String removecurrent(String s, char c) {
                StringBuilder sb =new StringBuilder();

                for(char ch :s.toCharArray()) {
                    if (ch != c) sb.append(ch);
                }
                
                
                return sb.toString();
            }
        }



        class Extract{ static String otherchars(String s, char c) {
                StringBuilder sb = new StringBuilder();
                for (char ch:s.toCharArray()) {
                    if (ch ==c) sb.append(c);
                }
                return sb.toString();
            }
        }


        if (Palindrome.check(str))return "";
        String oneonly =Remove.removecurrent(str,'0');
        if (Palindrome.check(oneonly))
            return Extract.otherchars(str,'0');
        String zeronly= Remove.removecurrent(str, '1');

        if (Palindrome.check(zeronly))
            return Extract.otherchars(str, '1');

        return str;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t--> 0){
            String s = sc.next();
            System.out.println(solve(s));
        }
    }
}
