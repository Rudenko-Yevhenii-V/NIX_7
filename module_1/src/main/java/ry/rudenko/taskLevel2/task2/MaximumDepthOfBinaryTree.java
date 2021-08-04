package ry.rudenko.taskLevel2.task2;

public class MaximumDepthOfBinaryTree {

  public static int MaximumDepthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(MaximumDepthOfBinaryTree(root.left), MaximumDepthOfBinaryTree(root.right));
  }

}