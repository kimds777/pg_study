package pg_git;

class MakeJadenCaseString {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		
		boolean checkChar = false; // false -> 대문자 , true -> 소문자
		for (char c : s.toCharArray()) {
			if (c == ' ') { // 문자가 공백인 경우
				checkChar = false;
				sb.append(' ');
				continue;
			} else { // 문자가 공백이 아닌 경우
				if (!checkChar) { // false -> 대문자
					sb.append(Character.toUpperCase(c));
					checkChar = true;
				} else { // true -> 소문자
					sb.append(Character.toLowerCase(c));
				}
			}
		}
		
		return sb.toString();
	}
}

public class Lv2_makeJadenCaseString {
	public static void main(String[] args) {
		String s = " for the last week ";

		String ans = new MakeJadenCaseString().solution(s);
		System.out.println(ans);
	}
}
