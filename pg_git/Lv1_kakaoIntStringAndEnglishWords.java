package pg_git;

class KakaoIntStringAndEnglishWords {
	public int solution(String s) {
		s =  s.replace("zero", "0").replace("one", "1").replace("two", "2").replace("three", "3")
				.replace("four", "4").replace("five", "5").replace("six", "6").replace("seven", "7")
				.replace("eight", "8").replace("nine", "9");
		int answer = Integer.parseInt(s);
		return answer;
	}
}

public class Lv1_kakaoIntStringAndEnglishWords {
	public static void main(String[] args) {
		KakaoIntStringAndEnglishWords k = new KakaoIntStringAndEnglishWords();
		System.out.println(k.solution("one4seveneight"));
	}
}
