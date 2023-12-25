package pg_git;

import java.util.HashSet;
import java.util.Set;

class TheCodeOfTheTwoOfUs {
	public String solution(String s, String skip, int index) {
		Set<Character> skipChar = new HashSet<>();

		for (char sk : skip.toCharArray()) { // skip 문자열에 포함된 문자를 Set에 넣어준다.
			skipChar.add(sk);
		}

		StringBuilder sb = new StringBuilder();
		
		for (char ss : s.toCharArray()) {
			char temp = ss;
			int cnt = 0;
			
			while (cnt < index) { // cnt가 index보다 작을때까지만 반복
				temp++; //temp에 1을 더하여 다음 알파벳으로 이동
				
				if(temp == '{') { // temp가 'z'의 다음 아스키코드인 '{'인 경우
					temp = 'a'; // temp를 'a'로 변경해준다.
				}
				
				if(!skipChar.contains(temp)) { // temp값이 skipChar에 들어있지 않은 경우
					cnt++; // cnt에 1을 더해준다.
				}
			}
			sb.append(temp); // cnt가 index와 같아진 경우 반복문을 빠져나오고 sb에 temp값을 넣어준다.
		}

		return sb.toString();
	}
}

public class Lv1_theCodeOfTheTwoOfUs {
	public static void main(String[] args) {
		String s = "aukks";
		String skip = "wbqd";
		int index = 5;

		String ans = new TheCodeOfTheTwoOfUs().solution(s, skip, index);
		System.out.println(ans);
	}
}
