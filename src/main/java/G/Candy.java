package G;

public class Candy {
    public static void main(String[] args) {
        int [] input = {1,0,2};
        System.out.println(new Candy().candy(input));
    }
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0) return 0;
        int up=0,down=0,peek=0;
        int res =0;
        for(int i=1;i<ratings.length;i++){
           if(ratings[i-1]<ratings[i]){
               ++up;
               down=0;
               res +=1+up;

           } else if(ratings[i-1]==ratings[i]){
               up=0;
               down=0;
               res +=1;

           } else {
               ++down;
               up=0;
               res +=1+down;
           }
        }
        return res;
    }
}
