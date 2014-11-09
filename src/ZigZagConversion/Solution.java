package ZigZagConversion;

import java.util.ArrayList;
/**
 * Created by juntakuo on 11/8/14.
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *  P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
    public static String convert(String s, int nRows) {
        // base case nRows = 1
        if (nRows == 1) return s;

        ArrayList<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0 ; i < nRows ; ++i) rows.add(new StringBuilder());

        int row = 0;
        boolean down = false;
        for (int i = 0 ; i < s.length(); ++i) {
            if (row == 0) down = true;
            else if (row == nRows-1) down = false;

            rows.get(row).append(s.charAt(i));

            if (down)  ++row;
            else --row;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : rows) sb.append(stringBuilder);
        return sb.toString();
    }
}
