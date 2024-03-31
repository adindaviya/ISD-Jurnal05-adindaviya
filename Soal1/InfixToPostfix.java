package Soal1;

import java.util.Stack; 
public class InfixToPostfix { /*kelas */

    static boolean isOp(char c) { /*method isOp = untuk mengecek apakah karakter c adalah operator */
        return (c == '+' || c == '-' || c == '/' || c == '*' ||  c == '^'); /*ika karakter adalah operator, maka method akan mengembalikan true, dan jika tidak, maka akan mengembalikan false */
    }

    static int getPrecedence(char op) { /*method getPrecedence = untuk mengembalikan prioritas operator */
        switch(op){         /*jika karakter adalah operator, maka method akan mengembalikan prioritas operator tersebut, dan jika tidak, maka akan mengembalikan -1 */
            case '+':      
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    static String InfixToPostfix(String infix) { /*method infix to postfix = untuk mengubah notasi infix menjadi notasi postfix */
        Stack<Character> operatorstacks =  new Stack<Character>(); 
        StringBuilder postfixBuilder =  new StringBuilder(); 

        for(int i = 0; i < infix.length(); i++ ) { /*menggunakan perulangan for */
            char c =  infix.charAt(i); 

            if(c == ' ') {
                continue;
            }
            if(!isOp(c)) {
                postfixBuilder.append(c);

            }
            else {
                while(!operatorstacks.isEmpty() && getPrecedence(operatorstacks.peek()) >= getPrecedence(c)) {
                    postfixBuilder.append(operatorstacks.pop());
                }
                operatorstacks.push(c);
            }
        }
        while(!operatorstacks.isEmpty()) {
            postfixBuilder.append(operatorstacks.pop());
        } 

        String postfix = postfixBuilder.toString();
        return postfix;
    }
    public static void main(String[] args) { /*method main = untuk menjalankan program*/
        String infix = "a * b - c"; 
        String postfix = InfixToPostfix(infix);
        System.out.println("infix "  + infix);
        System.out.println("postfix " + postfix);
    }
}

/*Link YouTube : https://youtu.be/07LDjAJgLIw?si=3OGRExKFeH8NUJol */