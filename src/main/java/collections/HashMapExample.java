package collections;


import java.util.*;

public class HashMapExample {
    static HashMap<String,Book1> hs = new HashMap<String,Book1>();
    public static void main(String[] a){
      //  Book b2= new Book(2,"b2","a2",2);
        hs.put(2+"",(new Book1(2,"b2","a2",2)));
        hs.put(5+"",(new Book1(5,"b5","a5",5)));
        hs.put(1+"",(new Book1(1,"b1","a1",1)));
        hs.put(3+"",(new Book1(3,"b3","a3",3)));
        Set<Map.Entry<String,Book1>> s = hs.entrySet();
        Iterator<Map.Entry<String,Book1>> it = s.iterator();
        while (it.hasNext()){
            System.out.println(it.next().getValue().id);

        }
        System.out.println("after sorting ");
        HashMap<String,Book1> hs1=sortMapUsingArray(hs);
        Set<Map.Entry<String,Book1>> s1 = hs1.entrySet();
        Iterator<Map.Entry<String,Book1>> it1 = s1.iterator();
        while (it1.hasNext()){
            System.out.println(it1.next().getValue().id);

        }

    }

    public static HashMap<String,Book1>  sortMapUsingArray(HashMap<String,Book1> hs){
        List ls = new ArrayList(hs.entrySet());
        Collections.sort(ls, new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                       Book1 b1= (Book1)(((Map.Entry) (o1)).getValue());
                        Book1 b2= (Book1)(((Map.Entry) (o2)).getValue());
                        if (b1.id>b2.id){
                            return 1;
                        } else if (b1.id<b2.id){
                            return -1;
                        } else{
                            return 0;
                        }
                    }
                }

        );
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = ls.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
       return sortedHashMap;
    }

}
