import java.util.*;

public class ValidParenthesis {
    public  static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                if ((top == '(' && ch != ')') || (top == '[' && ch != ']') || (top == '{' && ch != '}')) {
                    return false;
                }
            }
        }
        
        return stack.empty();
    }
    public static boolean duplicateParen(String str) {
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            // closing
            if(ch==')'){
                int count=0;
                while(!s.empty() && s.peek()!='('){
                    s.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }
                else{
                    s.pop();
                }
            }
            else{
                s.push(ch);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println(isValid(str));
        String s1 = "((a+b))";
        String s2 = "(a-b)";
        System.out.println(duplicateParen(s1));
        System.out.println(duplicateParen(s2));
    }
}
