package pg_git;

import java.util.Stack;

class CorrectBracket {
	boolean solution(String s) {
		Stack<Character> brackets = new Stack<>(); // 괄호를 저장할 스택
		for (char c : s.toCharArray()) {
			if (!brackets.empty()) { // brackets이 비어있지 않은 경우
				if (brackets.peek() == '(' && c == ')') { // brackets에 가장 마지막에 추가된 문자가 '('이고 c 문자가 ')' 인 경우 
					brackets.pop(); // brackets에 가장 마지막에 추가된 문자 삭제
					continue; // for문으로 돌아간다.
				}
			}
			brackets.push(c); // brackets이 비어있는 경우 -> brackets에 c 문자를 넣어준다.
		}
		
		return brackets.empty(); // 모두 올바른 괄호인 경우 brackets은 비어있어야한다.
	}
}

public class Lv2_correctBracket {
	public static void main(String[] args) {
		String s = "()()";
		boolean ans = new CorrectBracket().solution(s);
		System.out.println(ans);
	}
}
