package practice.problemSolving.trees;

import practice.dataStructures.trees.TreeNode;

/**
 * Create binary tree of minimum depth using sorted array
 *
 * @author Yashraj R. Sontakke
 */
public class MinimalBST_4_3 {

    TreeNode createMinimalBST(final int[] a, final int start, final int end) {
        if (end < start) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(a[mid]);
        n.setLeftChild(createMinimalBST(a, start, mid - 1));
        n.setRightChild(createMinimalBST(a, mid + 1, end));
        return n;
    }

    public static void main(String[] args) {
        MinimalBST_4_3 minimalBST = new MinimalBST_4_3();
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode n = minimalBST.createMinimalBST(a, 0, a.length - 1);



    }

}
