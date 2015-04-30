package practice.otherProblems.trees;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * <p/>
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * <p/>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author Yashraj R. Sontakke
 */
public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        int[] sum = new int[n + 1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                sum[i] += sum[j] * sum[i - 1 - j];
            }
        }
        return sum[n];
    }


    public static void main(String[] args){
        UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
        System.out.println(u.numTrees(3));
    }
}
