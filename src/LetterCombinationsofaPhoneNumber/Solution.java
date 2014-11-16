package LetterCombinationsofaPhoneNumber;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by juntakuo on 11/16/14.
 * Given a digit string, return all possible letter combinations that the number could represent.
 * <p/>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class Solution {
    public static void main(String[] args) {
        List<String> ret = letterCombinations("2");
        for (String s : ret) {
            System.out.println(s);
        }
    }

    public static String[] keyMap = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            List<String> ret = new ArrayList<String>();
            ret.add("");
            return ret;
        }

        List<String> ret = new ArrayList<String>();

        int first = Character.getNumericValue(digits.charAt(0));
        if (first > 1) {
            String remain = digits.substring(1);
            String alphabets = keyMap[first - 2];
            for (int i = 0; i < alphabets.length(); ++i) {
                char c = alphabets.charAt(i);

                for (String str : letterCombinations(remain)) {
                    ret.add(c + str);
                }

            }
        } else {
            throw new RuntimeException();
        }
        return ret;

    }

    public static ArrayList<String> getAllCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<String>();

        ArrayList<String> ret = new ArrayList<String>();

        int first = Character.getNumericValue(digits.charAt(0));
        if (first > 1) {
            String remain = digits.substring(1);
            String alphabets = keyMap[first - 2];
            for (int i = 0; i < alphabets.length(); ++i) {
                char c = alphabets.charAt(i);
                if (remain.length() > 0) {
                    for (String str : getAllCombinations(remain)) {
                        ret.add(c + str);
                    }
                } else {
                    ret.add(c + "");
                }
            }
        } else {
            throw new RuntimeException();
        }
        return ret;
    }
}
