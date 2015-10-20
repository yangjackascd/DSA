package practicalmockexam;

import java.util.Stack;

/* Question 1: Detecting if all brackets in the given string are matching
 */
public class ExpProcessor {

    /**
     * You need to complete this method using the Stack data structure
     *
     * @param str
     */
    public static void bracket(String str) {
        str = str.trim();
        Stack<String> data = new Stack<>();
        /////write your code below
       
        for (int i = 0; i < str.length(); i++) {
            
            switch (str.charAt(i)) {
                case ' ':
                    break;
                case '(':
                    data.push("(");
                    break;
                case '{':
                    data.push("{");
                    break;
                case '[':
                    data.push("[");
                    break;
                case '<':
                    data.push("<");
                    break;
                case ')':
                    if (data.pop().compareTo("(") != 0) {
                        System.out.println("The parentheses are not matching");
                        return;
                    }
                    break;
                case '}':
                    if (data.pop().compareTo("{") != 0) {
                        System.out.println("The parentheses are not matching");
                        return;
                    }
                    break;
                case ']':
                    if (data.pop().compareTo("[") != 0) {
                        System.out.println("The parentheses are not matching");
                        return;
                    }
                    break;
                case '>':
                    if (data.pop().compareTo("<") != 0) {
                        System.out.println("The parentheses are not matching");
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid String");
                    return;
            }
            System.out.println(data);
        }
        if (!data.isEmpty()) {
            System.out.println("The parentheses are not matching");
        } else {
            System.out.println("The parentheses are matching");
        }

        /////Write your code above
    }

    //You should not modify the main method in anyway    
    public static void main(String[] args) {
        bracket("((((()()()");
        bracket("{((<>))[][](())}");
        bracket("<(())()()(( )))");
        bracket("([<>][[{ }] ])");
        bracket("((<<))>>");
        bracket("(a)");

        /**
         * Expected Output: The parentheses are not matching The parentheses are
         * matching The parentheses are not matching The parentheses are
         * matching The parentheses are not matching Invalid String
         */
    }
}
