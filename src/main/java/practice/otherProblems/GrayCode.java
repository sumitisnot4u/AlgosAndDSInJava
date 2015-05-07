package practice.otherProblems;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p/>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
 * <p/>
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * <p/>
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * <p/>
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * <p/>
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 *
 * @author Yashraj R. Sontakke
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        if (n < 0) {
            return result;
        }
        if (n == 0) {
            result.add(0);
            return result;
        }
        result.add(0);
        result.add(1);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>(result);
            int a = 1 << i;
            for (int j = result.size() - 1; j >= 0; j--) {
                temp.add(result.get(j) + a);
            }
            result = temp;

        }
        return result;
    }

    public static void main(String[] args){
        GrayCode g = new GrayCode();
        System.out.println(g.grayCode(2).toString());
        System.out.println(g.grayCode(4).toString());
    }
}