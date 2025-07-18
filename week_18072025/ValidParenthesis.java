package week_18072025;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i= 0; i < s.length(); i++) {

            char current_char = s.charAt(i);
            if(current_char == '(' || current_char == '[' || current_char == '{')
                stack.add(current_char);

            else if (stack.isEmpty())
                return false;

            else{
                switch (current_char) {
                    case ')':
                        if (stack.pop()!='(') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.pop()!='{') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.pop()!='[') {
                            return false;
                        }
                        break;
                }
            }
        }

        return (stack.isEmpty());


    }

}
