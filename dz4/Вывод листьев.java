import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinarySearchTreeLeaves {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeNode root = null;

        while (true) {
            int num = scanner.nextInt();
            if (num == 0) {
                break;
            }
            root = insert(root, num);
        }

        ArrayList<Integer> leaves = new ArrayList<>();
        collectLeaves(root, leaves);
        Collections.sort(leaves);

        for (int leaf : leaves) {
            System.out.println(leaf);
        }
    }

    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void collectLeaves(TreeNode root, ArrayList<Integer> leaves) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }

        collectLeaves(root.left, leaves);
        collectLeaves(root.right, leaves);
    }
}
