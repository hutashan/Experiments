package datastructure;

import java.util.Random;

/**
 * Created by parmana on 5/3/17.
 */
public class TreeNodeWithRandomGet {

    private int data;
    public TreeNodeWithRandomGet left;
    public TreeNodeWithRandomGet right;
    public int size=0;

    public  TreeNodeWithRandomGet(int v){
        data=v;
        size=1;
    }

    public void insertIorder(int v){

        if(v<=data){
            if(left==null){
                left= new TreeNodeWithRandomGet(v);
            } else {
                left.insertIorder(v);
            }

        } else {

            if(right==null){
                right= new TreeNodeWithRandomGet(v);
            } else {
                right.insertIorder(v);
            }
        }
        size++;
    }


    public TreeNodeWithRandomGet getRanddom(){

        int leftsize =left ==null?0:left.size();
       // if(leftsize==0) return this;
        int index = new Random().nextInt(leftsize);
        if(index<leftsize){
           return left.getRanddom();
        } else if(index==leftsize){
            return this;
        } else {
            return right.getRanddom();
        }

    }

    public int size() { return size; }
    public int data() { return data; }
    public static void main(String[] args) {
        TreeNodeWithRandomGet obj= new TreeNodeWithRandomGet(20);
        obj.insertIorder(10);
        obj.insertIorder(30);
        obj.insertIorder(5);
        obj.insertIorder(35);
        System.out.println(obj.getRanddom().data());
        System.out.println(obj.getRanddom().data());
        System.out.println("");

    }

}
