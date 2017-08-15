package collections;


import java.util.TreeSet;

public class TreeHashExample {
    static TreeSet<Book> tr=new TreeSet<Book>();
    public static void main(String[] a){
        tr.add(new Book(2,"b2","a2",2));
        tr.add(new Book(5,"b5","a5",5));
        tr.add(new Book(1,"b1","a1",1));
        tr.add(new Book(3,"b3","a3",3));
        for (Book b:tr){
            System.out.println(b.id);
        }
    }
}
