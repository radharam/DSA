package src.main.java.interviewbit.trees.binarytrees;

/*
Max Sum Path in Binary Tree
Problem Description
Given a binary tree T, find the maximum path sum.
The path may start and end at any node in the tree.

Problem Constraints
1 <= Number of Nodes <= 7e4
-1000 <= Value of Node in T <= 1000

Input Format
The first and the only argument contains a pointer to the root of T, A.

Output Format
Return an integer representing the maximum sum path.



Example Input

Input 1:

    1
   / \
  2   3
Input 2:

       20
      /  \
   -10   20
        /  \
      -10  -50


Example Output

Output 1: 6
Output 2: 40


Example Explanation
Explanation 1:
     The path with maximum sum is: 2 -> 1 -> 3
Explanation 2:
     The path with maximum sum is: 20 -> 20
 */

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class MaxSumPathInBinaryTree {

    int maxPathSum = Integer.MIN_VALUE; // initialise to min val, to support neg value from root
    public int maxPathSum(TreeNode A) {

        maxPath(A);
        return maxPathSum;
    }

    public int maxPath(TreeNode root) {
        if(root == null) return 0;
        int l = maxPath(root.left);
        int r = maxPath(root.right);

        // compute maxSumPath at each node
        //maxPathSum = Math.max(maxPathSum, root.val + Math.max(l, 0) + Math.max(r, 0));

        maxPathSum = Math.max(maxPathSum, Math.max(root.val, root.val + l + r));


        // return max sum from left right of a node, else if -ve return 0
        //return root.val + Math.max(0, Math.max(l, r));

        return Math.max(root.val, root.val + Math.max(l, r));
    }
}
