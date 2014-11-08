package reverseWords;

/**
 * Created by juntakuo on 11/8/14.
 */
public class Solution {
    public static void main(String[] args) {
        String str = "this is  a book     and a pencil";
        System.out.println(reverseWords(str));
    }
    public static String reverseWords(String s) {
        if (s == null) return null;
        if (s.length() == 0 || s == "") return s;

        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (int i = words.length - 1; i >= 0 ; --i) {
            words[i] = words[i].trim();
            if (words[i].length() > 0) {
                sb.append(prefix);
                sb.append(words[i]);
            }
            prefix = " ";
        }
        return sb.toString();
    }
}
