package SerializeDeserializeBT;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class SerializeDeserializeBT {
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
    public static String serialize(TreeNode root){
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr==null){
                sb.append("#,");
            }else{
                sb.append(curr.val).append(",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }

        }
        return sb.toString();
    }
    public static TreeNode deserialize(String serialized){
       if(serialized.isEmpty()){
           return null;
       }
       StringBuilder sb = new StringBuilder(serialized);
       Integer commaIndex  = sb.indexOf(",");
       String str = sb.substring(0,commaIndex);
       sb.delete(0,commaIndex+1);
       TreeNode root = new TreeNode(Integer.parseInt(str));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            commaIndex  = sb.indexOf(",");
            str = sb.substring(0,commaIndex);
            sb.delete(0,commaIndex+1);
            if(!str.equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(str));
                curr.left = left;
                q.offer(left);
            }

            commaIndex  = sb.indexOf(",");
            str = sb.substring(0,commaIndex);
            sb.delete(0,commaIndex+1);

            if(!str.equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(str));
                curr.right = right;
                q.offer(right);
            }
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.print("Orignal Tree: ");
        inorder(root);
        System.out.println();

        String serialized = serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized =  deserialize(serialized);
        System.out.print("Tree after deserialization: ");
        inorder(deserialized);
        System.out.println();
    }
}
