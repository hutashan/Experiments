package datastructure;

import java.util.HashMap;


public class TriesNode {
    public HashMap<Character,TriesNode> dict = new  HashMap<Character,TriesNode>();
    public char c;
    public  boolean isleaf=false;
    public String key;
}
