package pg_git;

class SmallSize {
	public int solution(String t, String p) {
		int answer = 0;
		long pInt = Long.parseLong(p);
		int leng = p.length();

		for (int i = 0; i < t.length() - (leng - 1); i++) {
			long temp = Long.parseLong(t.substring(i, i + leng));
			if (temp <= pInt) {
				answer++;
			}
		}

		return answer;
	}
}

public class Lv1_smallSizePartString {
	public static void main(String[] args) {
		SmallSize ss = new SmallSize();
		System.out.println(ss.solution("3141592", "271"));
	}
}
