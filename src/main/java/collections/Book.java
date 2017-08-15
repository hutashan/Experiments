package collections;

public class Book implements Comparable<Book>{
    int id;
    String name,author;
    int quality;

    public Book(int id,String n,String a,int q ){
        this.id = id;
        this.name=n;
        this.author=a;
        this.quality=q;
    }
    public int compareTo(Book o){
        if (o.id>id){
            return 1;
        } else if (o.id<id){
            return -1;
        } else{
            return 0;
        }
    }
}