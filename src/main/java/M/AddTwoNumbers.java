package M;
import F.ListNode;

import java.util.Stack;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode ls = new ListNode(7);
        ls.next=new ListNode(2);
        ls.next.next=new ListNode(4);
        ls.next.next.next=new ListNode(3);
        ListNode ls1 = new ListNode(5);
        ls1.next=new ListNode(6);
        ls1.next.next=new ListNode(4);
        ListNode r = new AddTwoNumbers().addTwoNumbers(ls,ls1);
        while (r!=null){
            System.out.println(r.val);
            r = r.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        Stack<Integer> st = new Stack<Integer>();
        while (l1!=null){
            st.push(l1.val);
            l1=l1.next;
        }
        Stack<Integer> st2= new Stack<Integer>();
        while (l2!=null){
            st2.push(l2.val);
            l2=l2.next;
        }
        int carry =0;
        Stack<Integer> st3= new Stack<Integer>();
        while ((!st.isEmpty()) || (!st2.isEmpty())){
            int x=0 ,y=0;
            if(!st.isEmpty()) {
                 x = st.pop();
            }
            if(!st2.isEmpty()) {
                y = st2.pop();
            }
            int res = x+y+carry;
            carry=0;
            int stva =res%10;
            if(res>9){
                carry=res/10;

            }
            st3.push(stva);


        }
        if(carry!=0){
            st3.push(carry);
        }
        ListNode ls = null;
        ListNode res = null;
        while ((!st3.isEmpty())){
            if(res==null){
                res= new ListNode(st3.pop());
                ls=res;
            } else{
                ls.next =  new ListNode(st3.pop());
                ls = ls.next;
            }
        }

        return res;
    }
}
