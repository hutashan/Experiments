package datastructure;


import java.util.Stack;

public class Tower {
    Stack<Integer> disk;
    int Index;

    public Tower(int index){
        this.Index = index;
        disk = new Stack<Integer>();
    }

    public void addDisk (int d) throws Exception {

        if (!(disk.isEmpty()) && disk.peek()<=d){
            throw new Exception("Not valid");
        }else{
            disk.push(d);
        }

    }

    public void moveTop (Tower t) throws Exception {
        int value = disk.pop();
        t.addDisk(value);
        System.out.println("Move disk from " + value +" tower");
    }


    public void moveDisk (int n ,Tower destination, Tower buffer) throws Exception {
        if (n>0){
            moveDisk(n-1,buffer,destination);
            moveTop(destination);
            buffer.moveDisk(n-1,destination,this);
        }
    }

    public static void main (String arg[]) throws Exception {
        int n =3;
        Tower[] towers = new Tower[3];
        for (int i=0;i<3;i++){
            towers[i]=new Tower(i);

        }
        for (int i=n-1;i>=0;i--){
            towers[0].addDisk(i);
        }
        towers[0].moveDisk(n, towers[2], towers[1]);

        for (int i=0 ;i< towers[2].disk.size();i++){
            System.out.println("Disk" + towers[2].disk.pop());
        }

    }






}
