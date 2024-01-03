package pg_git;

class MakingHamburgers {
	public int solution(int[] ingredient) {
		StringBuilder sb = new StringBuilder(); // StringBuilder 생성
		for (int i : ingredient) {
			sb.append(i); // ingredient를 ab에 넣어 문자열로 만든다.
		}

		int answer = 0;
		for (int s = 0; s < sb.length() - 3; s++) { // "1234"의 길이는 4이므로 sb의 길이에서 3을 뺀 길이만큼만 탐색을 한다.
			String hamburger = sb.substring(s, s + 4); // sb에서 길이 s부터 s+4전의 문자열을 가져온다
			if (hamburger.equals("1231")) { //hamburgur가 "1231"과 동일한 경우
				answer++; //answer에 1을 증가
				sb = sb.delete(s, s + 4); //sb에서 s부터 s+4전의 문자열을 지운다.
				s -= 3; //삭제된 hamburgur의 길이만큼 s에서 빼준다
				if (s <= -2) { //s의 값이 -2보다 작거나 같은 경우
					s = -1; //s를 -1로 초기화 해준다 -> for문에서 s++를 실행하면 s = 0이 되어 sb를 처음부터 다시 탐색한다.
				}
			}
		}

		return answer;
	}

//	시간 초과 발생!
//	 public int solution(int[] ingredient) {
//			String ingredients = Arrays.toString(ingredient).replaceAll("[^0-9]", "");
//			
//			while (ingredients.contains("1231")) {
//				ingredients = ingredients.replaceFirst("1231", "");
//			}
//			
//			int answer = (ingredient.length - ingredients.length()) / 4;
//			return answer;
//	}
}

public class Lv1_makingHamburgers {
	public static void main(String[] args) {
		int[] ingredient = { 1, 2, 3, 1, 1, 2, 3, 1 };

		int result = new MakingHamburgers().solution(ingredient);
		System.out.println(result);
	}
}
