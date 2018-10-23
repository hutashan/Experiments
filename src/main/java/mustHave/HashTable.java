package mustHave;

public class HashTable <K,V> {
    class Node<K,V> {
      K key;
      V value;
      Node next;

        Node (K key,V value){
          this.key = key;
          this.value=value;

      }
    }
    int size =0;
    int capacity =16;
    Node [] entity = null;

    public HashTable() {
        entity = new Node[capacity];
    }

    // ToDo for other data types
    private int getBucketNumber(K key){
        return hashCode(key)%capacity;
    }

    private int hashCode(K key) {

        return key.hashCode();

    }

    public boolean put(K key,V val){
        boolean changed = false;
        int bucketNumber = getBucketNumber(key);
        Node node = new Node(key,val);
        Node headNode = entity[bucketNumber];
        if(headNode==null){
            entity[bucketNumber]=node;
            size ++;
        }else{
            // update if same key
            while (headNode!=null){
                if(key.equals(headNode.key)){
                    headNode.value=val;
                    changed=true;
                    break;
                }
                headNode=headNode.next;
            }
            if(!changed) {
                node.next = entity[bucketNumber];;
                entity[bucketNumber] = node;
                size++;
            }
        }
        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0*size)/capacity >= 0.7) {
            Node [] tempEntity = entity;

            capacity = capacity*2;
            entity = new Node [capacity];
            for(int i=0;i<tempEntity.length;i++){
                Node headEntity = tempEntity[i];
                while(headEntity!=null){
                    put((K)headEntity.key,(V)headEntity.value);
                }
            }
        }


            return true;
    }

    public int getSize() {
        return size;
    }

    public V get(K key) throws Exception{
        int bucket = getBucketNumber(key);
        Node headNode = entity[bucket];
        if(headNode==null){
            throw new Exception("key not found");
        } else{
           return iterateKey(headNode,key);
        }
    }

    private V iterateKey(Node headNode , K key) throws Exception{
        while(headNode!=null ){
            if(key==headNode.key){
                return (V) headNode.value;
            }
            headNode=headNode.next;
        }
        throw new Exception("key not found");
    }


    private boolean iterateKeyAndRemove(Node headNode , K key) throws Exception{
        Node prev = headNode;
        while(headNode!=null ){

            if(key==headNode.key){
                 prev.next= headNode.next;
                 headNode.next = null;
                 headNode=null;
                 size--;
                 return true;

            }
            headNode=headNode.next;
            prev = headNode;
        }
        throw new Exception("key not found");
    }

    public boolean remove (K key)throws Exception{
        int bucket = getBucketNumber(key);
        Node headNode = entity[bucket];
        if(headNode==null) {
            throw new Exception("key not found");
        } else{
            iterateKeyAndRemove(headNode,key);
        }
        return true;

    }






    public static void main(String[] args) {
        HashTable<String,String> myHs = new HashTable();
        myHs.put("1","10");
        try {

            System.out.println(myHs.get("1")+"");
            myHs.put("2","20");
            myHs.put("3","30");
            myHs.put("4","40");
            myHs.put("4","45");
            myHs.put("5","50");
            myHs.put("18","180");
            myHs.put("25","250");
            System.out.println(myHs.get("2")+"");
            System.out.println(myHs.get("3")+"");
            System.out.println(myHs.get("4")+"");
            System.out.println(myHs.get("5")+"");
            System.out.println(myHs.get("18")+"");
            System.out.println(myHs.get("25")+"");
            System.out.println(myHs.size);
           // System.out.println(myHs.get("100")+"");
            myHs.remove("18");
            System.out.println(myHs.size);
            myHs.put("21","20");
            myHs.put("32","30");
            myHs.put("43","40");
            myHs.put("44","45");
            myHs.put("53","50");
            myHs.put("18","180");
            myHs.put("25","250");
            myHs.put("255","20");
            myHs.put("355","30");
            myHs.put("455","40");
            myHs.put("455","45");
            myHs.put("5555","50");
            myHs.put("18555","180");
            myHs.put("25555","250");




        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
