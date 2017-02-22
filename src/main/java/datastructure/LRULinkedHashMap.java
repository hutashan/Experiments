package datastructure;
        import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Set;

public class LRULinkedHashMap extends LinkedHashMap<String,String>{
    private static int s=5;
    private static float lf = 0.75f;
    private static boolean ac = true;


    public LRULinkedHashMap(){
        super(s,lf,ac);
    }
    protected boolean removeEldestEntry(Map.Entry eldest) {
        if (size() > s) {
            System.out.println("size limit and removing"+eldest.getKey());
            return true;
        } else {
            return false;
        }
    }
    public static void main(String a[]){
        LRULinkedHashMap lru = new LRULinkedHashMap();
        lru.put("1","1");
        lru.put("2","3");
        lru.put("3","3");
        lru.put("4","4");
        lru.put("5","5");
        lru.put("6","6");
        Set<String> keys = lru.keySet();
        for (String key : keys) {
            System.out.println("Cache contains:"+key);
        }
        lru.get("2");
        lru.put("7","7");
        Set<String> keys1 = lru.keySet();
        for (String key : keys1) {
            System.out.println("Cache contains:"+key);
        }
    }

}
