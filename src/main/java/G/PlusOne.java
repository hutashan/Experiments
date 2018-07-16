package G;

public class PlusOne {
    public static void main(String arg[]){
        int [] arr = {1,2,8};
        int [] newArr = new PlusOne().plusOne(arr);
        for (int i=0;i<newArr.length;i++){
            System.out.println(newArr[i]);
        }
       // System.out.println(new PlusOne().plusOne(arr));

    }
    public int[] plusOne(int[] digits) {
        if(digits.length==0) return digits;
        int carry=0;
        int offset =digits.length-1;
        int newNumber = digits[offset]+1;

        while(newNumber>=10 && offset>=0){
            digits[offset]= newNumber%10;
            carry=newNumber/10;
            offset --;
            if(offset>=0){
                newNumber =carry+digits[offset];
                carry=0;
            }

        }
        if(offset>=0) digits[offset]=newNumber;
        if(carry!=0){
            int [] newDigit = new int [digits.length+1];
            newDigit[0]=carry;
            for(int i=0;i<digits.length+1;i++){
               // int [] newDigit = new int [digits.length+1];
                newDigit[i+1]=digits[i];
                return newDigit;
            }
        }
        return  digits;
    }
}
