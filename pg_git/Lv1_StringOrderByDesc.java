package pg_git;

// 수정해야함! 통과못함!!
public class Lv1_StringOrderByDesc {
	public String solution(String s) {
		char[] answer = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			int a = answer[i];
			for (int j = i + 1; j < s.length(); j++) {
				int b = answer[j];
				if (a < b) {
					char temp = answer[i];
					answer[i] = answer[j];
					answer[j] = temp;
				}
			}
		}
		return String.valueOf(answer);
	}
}
