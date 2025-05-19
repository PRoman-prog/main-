import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SecondLargestElementInBST {

    private static int count = 0;
    private static int result = -1;

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

        findSecondLargest(root);
        System.out.println(result);
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

    public static void findSecondLargest(TreeNode root) {
        if (root == null || count >= 2) {
            return;
        }

        // Perform reverse in-order traversal
        findSecondLargest(root.right);

        count++;
        if (count == 2) {
            result = root.val;
            return;
        }

        findSecondLargest(root.left);
    }
}
