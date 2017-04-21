package simpleprob;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by v708178 on 4/20/17.
 */
public class MyCalc {
    int length;
    Stack stk;
    String exp, postfix;
    MyCalc(String s) {
        stk = new Stack();
        exp = s;
        postfix = "";
        length = exp.length();

    }
    public static void main (String[] arg){
        String st = "2 + ( 2 + 2 ) * 3 + 5 * 4 + 4 ";
        MyCalc calc = new MyCalc(st);
        calc.postfixExpression(calc.exp);
        System.out.println("st   " + st + "     exp   " + calc.postfix);
        calc.evaluateRPN(calc.postfix);
        System.out.println("v  " + calc.stk.toString());
    }

    void postfixExpression(String exp){
        String token = "";
        String[] exprArry = exp.split(" ");

        for (int i =0 ;i<exprArry.length;i++){
            String element = exprArry[i];
            char current = element.charAt(0);
            if (isNumber(element)){
                postfix = postfix +element + " ";
            } else if(isParentheses(current)) {
                if (current == '(') {
                   stk.push(current);
                } else {
                    Character ch = (Character) stk.peek();
                    char nextToken = ch.charValue();
                    while(nextToken != '(') {
                        postfix = postfix + stk.pop() + " ";
                        ch = (Character) stk.peek();
                        nextToken = ch.charValue();
                    }
                    stk.pop();
                }
            } else {
                if (stk.empty()) {
                    stk.push(current);
                } else {
                    Character ch = (Character) stk.peek();
                    char top = ch.charValue();
                    if (hasHigherPrecedence(top, current)) {
                        stk.push(current);
                    } else {
                    ch = (Character) stk.pop();

                    top = ch.charValue();

                    stk.push(current);

                    stk.push(top);
                }
              }
            }

        }
        try {
            Character ch = (Character) stk.peek();
            char nextToken = ch.charValue();

            while (isOperator(nextToken)) {
                postfix = postfix + stk.pop() + " ";
                ch = (Character) stk.peek();
                nextToken = ch.charValue();
            }
        } catch (EmptyStackException e) {}

    }
    boolean isOperator(char ch) {
        if ((ch == '-')) {
            return true;
        } else if ((ch == '+')) {
            return true;
        }
        else if ((ch == '*')) {
            return true;
        }
        else if((ch == '/')) {
            return true;
        } else {

        }
        return false;
    }
    boolean hasHigherPrecedence(char top, char current) {
        boolean HigherPre = false;

        switch (current) {
            case '*':
                HigherPre = true;
                break;

            case '/':
                HigherPre = true;
                break;

            case '+':

                if ((top == '*') || (top == '/') || (top == '-')) {
                    HigherPre = false;
                } else {
                    HigherPre = true;
                }

                break;

            case '-':
                if ((top == '*') || (top == '/') || (top == '-')) {
                    HigherPre = false;
                } else {
                    HigherPre = true;
                }
                break;

            default:
                System.out.println("Higher Precedence Unsuccessful was unable to be preformed.");
                break;
        }

        return HigherPre;


    }
    boolean isNumber(String s) {
        try {
            int Num = Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    boolean isParentheses(char current) {
        if ((current == '(') || (current == ')')) {
            return true;
        } else {
            return false;
        }
    }
    void evaluateRPN(String postfix) {
        String[] postfixArr = postfix.split(" ");
        String token = "";
        stk.clear();

        for (int i =0 ;i<postfixArr.length;i++ ) {
            try {
                token = postfixArr[i];
                if (isNumber(token)) {
                    stk.push(token);
                } else {
                    char current = token.charAt(0);
                    double t1 = Double.parseDouble(stk.pop().toString());
                    double t2 = Double.parseDouble(stk.pop().toString());
                    double t3 = 0;

                    switch (current) {
                        case '+': {
                            t3 = t2 + t1;
                            stk.push(t3);
                            break;
                        }
                        case '-': {
                            t3 = t2 - t1;
                            stk.push(t3);
                            break;
                        }
                        case '*': {
                            t3 = t2 * t1;
                            stk.push(t3);
                            break;
                        }
                        case '/': {
                            t3 = t2 / t1;
                            stk.push(t3);
                            break;
                        }
                        default: {
                            System.out.println("Reverse Polish Notation was unable to be preformed.");
                        }
                    }
                }

            } catch (EmptyStackException e) {
                e.printStackTrace();
            }
        }
    }

}
