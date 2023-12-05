package pg_git;

class Babble {
	public int solution(String[] babbling) {
		int answer = 0;

		for (String b : babbling) {
			b = b.replaceAll("ayaaya|yeye|woowoo|mama", " ");
			b = b.replaceAll("aya|ye|woo|ma", "");
			
			if (b.equals("")) {
				answer++;
			}

		}
		return answer;
	}
}

public class Lv1_babble {
	public static void main(String[] args) {
		String[] babbling = { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" }; 
		int ans = new Babble().solution(babbling);

		System.out.println(ans);
	}
}
