import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int makeAnagram(String a, String b) {
        int res = 0;
        for (char c : "abcdefghijklmnopqrstuvwxyz".toCharArray()) {
            int sumA = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == c) sumA++;
            }
            int sumB = 0;
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) == c) sumB++;
            }
            res = res + Math.abs(sumA - sumB);
        }
        return res;
    }

    static boolean isAnagrams(String s1, String s2) {
        return makeAnagram(s1, s2) <= 0;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {

        int result = 0;

        for (int i = 0; i < s.length()-1; i++) { //start point
            for (int j = 1; j < s.length() - i; j++) { //length
                String s1 = s.substring(i, i+j);
//                System.out.println("s1 = " + s1);

                for (int k = i+1; k < s.length() - j + 1; k++) { //start point 2
                    String s2 = s.substring(k, k + j);
//                    System.out.println("s2 = " + s2);
                    if (isAnagrams(s1, s2)) {
//                        System.out.println("s1 = " + s1 +", s2 = " + s2);
                        result++;
                    }
                }
                
            }
        }

        System.out.println(result);

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
