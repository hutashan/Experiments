package F;

import java.util.*;

public class BSTSerilalized {
    static TreeNode root =null;

    public static void main(String[] args) {
        root = TreeNode.makeTree3();
        String str = new BSTSerilalized().serialize(root);
        System.out.println( str);
        TreeNode root1= new BSTSerilalized().deserialize(str);
        new BSTSerilalized().pre(root1);

    }

    private void pre(TreeNode root1){
        System.out.println(root1.val+",");
        pre(root1.left);
        pre(root1.right);
    }


    public String serialize(TreeNode root) {
        StringBuffer st = new StringBuffer();
        treeSerialze(root,st);
        return st.toString();

    }
    private void treeSerialze(TreeNode root,StringBuffer st){
    if(root==null){
        st.append("N,");
        return ;
    }
    st.append(root.val).append(",");
    treeSerialze(root.left,st);
    treeSerialze(root.right,st);
    }
    public TreeNode deserialize(String data) {
        if(data==null) return null;
        String [] arr = data.split(",");
        LinkedList<String> ll = new LinkedList(Arrays.asList(arr));
        //TreeNode root = new TreeNode(Integer.parseInt(ll.poll()));
        return deserializeTree(ll);

    }
    public TreeNode deserializeTree( LinkedList<String>  list) {
        String n = list.poll();
        if(n.equals("N")){
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(n));
            node.left = deserializeTree(list);
            node.right = deserializeTree(list);
            return node;
        }
    }




    }
