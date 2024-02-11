package pg_git;

import java.util.Stack;

class ToRemoveInPairs {
	public int solution(String s) {
		Stack<Character> str = new Stack<>(); // 문자열 s의 문자를 저장할 Stack 생성

		for (char c : s.toCharArray()) { // for문 사용
			if (!str.isEmpty() && str.peek() == c) { // Stack이 비어있지 않고 Stack에 맨위 문자가 c와 동일한 경우
				str.pop(); // Stack의 맨위 문자를 삭제한다.
			} else { // Stack이 비어있거나 Stack의 맨위 문자가 c와 동일하지 않은 경우 
				str.push(c); // Stack에 c를 저장한다.
			}
		}

		if (str.isEmpty()) { // Stack이 비어있는 경우
			return 1; 
		}
		return 0; // Stack이 비어있지 않은 경우
	}
}

public class Lv2_toRemoveInPairs {
	public static void main(String[] args) {
		String s = "baabaa";

		int ans = new ToRemoveInPairs().solution(s);
		System.out.println(ans);
	}
}
