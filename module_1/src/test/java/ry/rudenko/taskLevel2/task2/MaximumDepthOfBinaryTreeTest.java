package ry.rudenko.taskLevel2.task2;

import static org.junit.Assert.*;
import static ry.rudenko.taskLevel2.task2.MaximumDepthOfBinaryTree.MaximumDepthOfBinaryTree;

import org.junit.Test;

public class MaximumDepthOfBinaryTreeTest {

  @Test
  public void maximumDepthOfBinaryTree() {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(45);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(66);
    root.right.right = new TreeNode(7);
    root.right.left.right = new TreeNode(132);
    root.right.left.left = new TreeNode(2);
    root.right.left.left.right = new TreeNode(772);
    int actual = MaximumDepthOfBinaryTree(root);
    int expected = 5;

    assertEquals(actual, expected);
  }
}