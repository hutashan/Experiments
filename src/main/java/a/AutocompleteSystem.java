package a;
import java.util.*;

public class AutocompleteSystem {
    Map<String,Integer> db = new HashMap<>();
    String sb = new String();

    public static void main(String[] args) {
        String [] s = {"i love you", "island","ironman", "i love leetcode"};
        int [] val = {5,3,2,2};

        AutocompleteSystem a = new AutocompleteSystem(s,val);
        System.out.println(a.input('i'));
        System.out.println(a.input(' '));


    }
    public void AutocompleteSystem1(String[] sentences, int[] times) {
        for(int i=0;i<sentences.length;i++){
            db.put(sentences[i],db.getOrDefault(sentences,0)+times[i]);
        }

    }

    public List<String> input1(char c) {
        List<String> ls = new ArrayList<>();
        if(c=='#'){
            db.put(sb.toString(),db.getOrDefault(sb.toString(),0)+1);
            sb="";
            return new ArrayList<>();
        }
        sb = sb+c;
        PriorityQueue<Map.Entry<String,Integer>> pr = new PriorityQueue<Map.Entry<String,Integer>>((x,y) -> (y.getValue()-x.getValue()));
        for(Map.Entry<String,Integer> entry:db.entrySet()){
            if(entry.getKey().startsWith(sb)){
                pr.add(entry);
            }
        }
        int k=3;
        while(!pr.isEmpty()){
            if(k>0) {
                ls.add(pr.poll().getKey());
                k--;
            }else{
                break;
            }
        }
        k=2;

        return ls;
    }



    class TrieNode {
        Map<Character, TrieNode> children;
        Map<String, Integer> counts;
        boolean isWord;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }

    class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s; this.c = c;
        }
    }

    TrieNode root;
    String prefix;


    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";

        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String s, int count) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.counts.put(s, curr.counts.getOrDefault(s, 0) + count);
        }
        curr.isWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;
        TrieNode curr = root;
        for (char cc : prefix.toCharArray()) {
            TrieNode next = curr.children.get(cc);
            if (next == null) {
                return new ArrayList<String>();
            }
            curr = next;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for (String s : curr.counts.keySet()) {
            pq.add(new Pair(s, curr.counts.get(s)));
        }

        List<String> res = new ArrayList<String>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            res.add(pq.poll().s);
        }
        return res;
    }



}
