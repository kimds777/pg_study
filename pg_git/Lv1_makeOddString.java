package pg_git;

class OddString {
	public String solution(String s) {
		s = s.toLowerCase();
		char[] charArr = s.toCharArray();
		int index = -1;
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == ' ') {
				index = -1;
			} else {
				++index;
				if (index == 0 || index % 2 == 0) {
					charArr[i] = Character.toUpperCase(charArr[i]);
				}
			}

		}
		return String.valueOf(charArr);
	}
}

public class Lv1_makeOddString {
	public static void main(String[] args) {
		OddString os = new OddString();
		System.out.println(os.solution("try hello world"));

	}
}
