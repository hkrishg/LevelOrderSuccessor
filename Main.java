import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val) {
    this.val = val;
  }
};

class Main {

  // Problem Statement #
  // Problem 1: Given a binary tree, find its minimum depth

  private static TreeNode findSuccessor(TreeNode root, int key) {
    if (root == null)
      return null;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode currentNode = queue.poll();
      // insert the children of current node to the queue
      if (currentNode.left != null)
        queue.add(currentNode.left);
      if (currentNode.right != null)
        queue.add(currentNode.right);
      if (currentNode.val == key)
        break;
    }
    return queue.peek();
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    TreeNode result = Main.findSuccessor(root, 12);
    System.out.println(result.val);
    TreeNode result1 = Main.findSuccessor(root, 9);
    System.out.println(result1.val);
  }
}