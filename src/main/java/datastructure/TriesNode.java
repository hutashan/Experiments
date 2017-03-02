package datastructure;

import java.util.HashMap;


public class TriesNode {
    HashMap<Character,TriesNode> dict = new  HashMap<Character,TriesNode>();
    char c;
    boolean isleaf;
}
