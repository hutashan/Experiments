package hardprob;

import java.util.*;

public class RandomizedCollection {
    HashMap<Integer,Set<Integer>> hs;
    ArrayList<Integer> ls;
    java.util.Random random;

    public RandomizedCollection() {
        hs = new HashMap<Integer,Set<Integer>>();
        ls = new ArrayList<Integer>();
        random = new java.util.Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        Boolean contains = hs.containsKey(val);
        if (contains){
            hs.get(val).add(ls.size());
        } else{
            hs.put(val,new HashSet<Integer>());
            hs.get(val).add(ls.size());
        }
        ls.add(val);
        return !contains;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Boolean contains = hs.containsKey(val);
        if (!contains) return false;
        int loc = hs.get(val).iterator().next();
        hs.get(val).remove(loc);
        int lastVal = ls.get(ls.size()-1);
        ls.add(loc,lastVal);
        hs.get(val).remove(ls.size()-1);
        hs.get(val).add(loc);
        if(hs.get(val).isEmpty()) hs.remove(val);
        ls.remove(ls.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return ls.get(random.nextInt(ls.size()));
    }
}
