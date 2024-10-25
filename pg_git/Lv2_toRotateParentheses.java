package pg_git;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lv2_toRotateParentheses {
    public static int solution(String s) {
        int answer = 0;

        Queue<Character> parentheseQue = new LinkedList();
        for (char c : s.toCharArray()) {
            parentheseQue.add(c);
        }

        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            
            String p = parentheseQue.toString().replaceAll(", ", "").substring(1, stringLength + 1);

            Stack<Character> checkString = new Stack();
            for (int j = 0; j < stringLength; j++) {
                char c = p.charAt(j);

                if (j == 0 && (c == ')' || c == ']' || c == '}')) {
                    checkString.push(')');
                    break;
                }

                if (checkString.empty()) {
                    checkString.push(c);
                } else {
                    char peekString = checkString.peek();

                    boolean case1 = (peekString == '(' && c == ')');
                    boolean case2 = (peekString == '[' && c == ']');
                    boolean case3 = (peekString == '{' && c == '}');

                    if (case1 || case2 || case3) {
                        checkString.pop();
                    } else {
                        checkString.push(c);
                    }
                }

            }

            if (checkString.size() == 0) {
                answer++;
            }

            char frontChar = parentheseQue.poll();
            parentheseQue.offer(frontChar);

        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "[{]}";
        System.out.println(solution(s));
    }
}
