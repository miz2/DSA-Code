import java.util.*;
public class PushBott {
    public static void pushAtBottom(Stack <Integer> s ,int data){
        if(s.empty()){
            s.push(data);
            return;
        }
        int top=s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    public static String reverseString(String str){
        Stack <Character> s=new Stack<>();
        int idx=0;
        while(idx<str.length()){
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result=new StringBuilder("");
        while(!s.empty()){
            char curr=s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    
    public static void reverseStack(Stack <Integer> s ){
        if(s.empty()){
            return;
        }
        int top=s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void printStack(Stack <Integer> s ){
        while(!s.empty()){
            System.out.println(s.pop());
        }
    }
    public static void main(String[] args) {
        Stack <Integer> s=new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s, 4);
        while (!s.empty()) {
            System.out.println(s.pop());
            
        }
        String str="abc";
        System.out.println(reverseString(str));
        // reverse stack 

         Stack <Integer> s1=new Stack<>();
         System.out.println("-------------");
         s1.push(1);
        s1.push(2);
        s1.push(3);
         printStack(s1);
         reverseStack(s1);
         printStack(s1);
    }
}
