package PostfixEval;

import java.util.Stack;

public class PostfixEval {
    public static int evalPostfix(String exp) throws Exception {
        Stack<Integer> st = new Stack<>();
        for(char c: exp.toCharArray()){
            if(Character.isDigit(c)){
                st.push(c-'0');
            }else{
                int y = st.pop();
                int x= st.pop();
                switch (c){
                    case '+':
                        st.push(x+y);
                        break;
                    case '-':
                        st.push(x-y);
                        break;
                    case '*':
                        st.push(x*y);
                        break;
                    case '/':
                        st.push(x/y);
                        break;
                    default:
                        throw new Exception("No Mathes");
                }
            }
        }
        return st.pop();
    }
    public static void main(String[] args) throws Exception {
        String exp = "138*+";
        System.out.println(evalPostfix(exp));
    }
}
