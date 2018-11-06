package practice.problems.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Solve a given equation and return the value of x in the form of string "x=#value". The equation contains only '+', '-' operation, the variable x and its coefficient.

 If there is no solution for the equation, return "No solution".

 If there are infinite solutions for the equation, return "Infinite solutions".

 If there is exactly one solution for the equation, we ensure that the value of x is an integer.

 Example 1:
 Input: "x+5-3+x=6+x-2"
 Output: "x=2"
 Example 2:
 Input: "x=x"
 Output: "Infinite solutions"
 Example 3:
 Input: "2x=x"
 Output: "x=0"
 Example 4:
 Input: "2x+3x-6x=x+2"
 Output: "x=-1"
 Example 5:
 Input: "x=x+2"
 Output: "No solution"
 */
public class SolveEquation {

    public String coeff(String x) {
        if (x.length() > 1 && x.charAt(x.length()-2) >='0' && x.charAt(x.length()-2) >='9') {
            return x.replace("x","");
        }
        return x.replace("x","1");
    }
    public String solveEquation(String equation) {
        String[] lr = equation.split("=");
        int lhs =0, rhs =0;
        for (String x: breakIt(lr[0])) {
            if (x.indexOf("x") >= 0) {
                lhs += Integer.parseInt(coeff(x));
            } else {
                rhs -= Integer.parseInt(x);
            }
        }
        for (String x: breakIt(lr[1])) {
            if (x.indexOf("x") >= 0) {
                lhs -= Integer.parseInt(coeff(x));
            } else {
                rhs += Integer.parseInt(x);
            }
        }
        if (lhs == 0) {
            if (rhs == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x=" + rhs / lhs;
    }

    public List< String > breakIt(String s) {
        List<String> res = new ArrayList<>();
        String r = "";
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '+' || s.charAt(i)=='-') {
                if (r.length() > 0) {
                    res.add(r);
                }
                r = "" + s.charAt(i);
            } else {
                r += s.charAt(i);
            }
        }
        res.add(r);
        return res;
    }

    public static void main(String[] args) {
        SolveEquation solveEquation = new SolveEquation();
        System.out.println(solveEquation.solveEquation("x+5-3+x=6+x-2"));
    }
}
