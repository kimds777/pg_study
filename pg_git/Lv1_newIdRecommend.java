package pg_git;

class NewIdRecommend {
	public String solution(String new_id) {
		StringBuilder sb = new StringBuilder();
		new_id = new_id.toLowerCase().replaceAll("[^-_.0-9a-z]", ""); //new_id를 소문자로 변경하고 특수문자'-_.'와 영어와 숫자를 제외한 문자는 제거
		sb.append(new_id); // 변경된 new_id를 StringBuilder에 넣는다.

		int cnt = -1;
		for (int i = 0; i < sb.length(); i++) { // '.'이 2개 이상 중복된경우 1개로 치환하는 반복문
			if (sb.charAt(i) == '.') { // i번째 char가 '.'인 경우
				cnt++; // cnt를 1씩 증가시킨다.
			}else if (cnt <= 0) { //i번째 char가 '.'가 아니고 cnt가 0이하인 경우
				cnt = -1; // cnt를 -1로 초기화시킨다.
			}

			if (cnt > 0) { // cnt가 1이상인 경우
				sb = sb.delete(i - cnt, i); //'.' 하나만 삭제
				i = i - cnt -1;
				if (i < -1) {
					i = -1;
				}

				cnt = -1;
			}
		}

		removeFirstIndexDotAndLastIndexDot(sb); // sb 처음과 끝에 있는 '.' 삭제

		if (sb.length() == 0) { //sb의 길이가 0인 경우
			sb.append("a"); // 'a'를 대입
		} else if (sb.length() > 15) { //sb의 길이가 16이상인 경우
			sb = sb.delete(15, sb.length()); // 15개 문자를 제외한 나머지 문자들 제거
		}

		removeFirstIndexDotAndLastIndexDot(sb); // sb 처음과 끝에 있는 '.' 삭제

		if (sb.length() <= 2) { //sb의 길이가 2이하인 경우
			char lastChar = sb.charAt(sb.length() - 1); //sb의 마지막 문자를 가져와
			while (sb.length() < 3) { //sb의 길이가 3이 될때까지 sb에 넣는다.
				sb.append(lastChar);
			}
		}

		return sb.toString();
	}

	public StringBuilder removeFirstIndexDotAndLastIndexDot(StringBuilder sb) {
		if (sb.length() != 0) { //sb의 길이가 0이 아닌 경우

			if (sb.charAt(0) == '.') { //sb 첫번째 문자가 '.' 경우
				sb = sb.delete(0, 1); //삭제

				if (sb.length() == 0) { //sb의 길이가 0인 경우
					return sb;
				}
			}

			if (sb.charAt(sb.length() - 1) == '.') { //sb 마지막 문자가 '.' 경우
				sb = sb.delete(sb.length() - 1, sb.length()); // 삭제
			}
		}

		return sb;
	}
}

public class Lv1_newIdRecommend {
	public static void main(String[] args) {
		String new_id = "";

		String ans = new NewIdRecommend().solution(new_id);
		System.out.println(ans);
	}
}
