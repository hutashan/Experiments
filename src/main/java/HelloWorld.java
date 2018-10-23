import java.util.* ;
class HelloWorld {
    public static void main(String args[]) {
        System.out.println("Hello world - Java!");
        int[] input = {1 , 3 , 5,  2,  0,  1,  8,  1};
        HelloWorld obj = new HelloWorld();
       System.out.println(obj.canWin(input,4));
        System.out.println(obj.canWin(input,5));
        System.out.println(obj.canWin(input,3));
        System.out.println(obj.canWin(input,6));

    }
    public boolean canWin(int[] input,int index){
        return canwinRecus(input,index,new HashSet<Integer>());
    }
    private boolean canwinRecus(int[] input,int index,HashSet<Integer> visited){
        if(index<0 || index >input.length-1) return false;
        if(input[index]==0){
            return true;
        } else if(input[index]>input.length-1) {
            return false;
        }
        // left

        visited.add(index);
        int left = index-input[index];
        boolean le=false;
        boolean ri = false;
        if(!visited.contains(left) )
            le= canwinRecus(input,index-input[index],visited);

        // right
        int right = index+input[index];
        if(!visited.contains(right))
            ri= canwinRecus(input,index+input[index],visited);
        return ri||le;
    }
}