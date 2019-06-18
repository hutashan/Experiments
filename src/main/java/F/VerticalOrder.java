package F;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
public class VerticalOrder {

    public static void main(String[] args) {

        List<List<Integer>> ls =new VerticalOrder().verticalOrder(TreeNode.makeTree3());
        for(List<Integer> l1 : ls){
            for(int i : l1){
                System.out.println(i);
            }
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        initMap(root, map, 0);
        List<List<Integer>> ls = new ArrayList<>();
        if (root == null) return ls;
        int size = max - min + 1;
        for (int i = 0; i < size; i++) {
            ls.add(new ArrayList<>());
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int mp =map.get(node);
            int index = mp- min;
            ls.get(map.get(node) - min).add(node.val);
            if (node.left != null) { q.offer(node.left); }
            if (node.right != null) { q.offer(node.right); }
        }
        return ls;
    }

    private int max = Integer.MIN_VALUE;

    private int min = Integer.MAX_VALUE;

    private void initMap(TreeNode node, Map<TreeNode, Integer> map, int level) {
        if (node == null) { return; }
        max = Math.max(max, level);
        min = Math.min(min, level);
        map.put(node, level);
        initMap(node.left, map, level - 1);
        initMap(node.right, map, level + 1);
    }

}
