package datastructure;

import java.util.HashMap;

/**
 * Created by parmana on 2/22/17.
 */
public class TriesNode {
    HashMap<Character,TriesNode> dict = new  HashMap<Character,TriesNode>();
    char c;
    boolean isleaf;
}
