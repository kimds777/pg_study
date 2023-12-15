package pg_git;

import java.util.ArrayList;
import java.util.List;

class StringDivision {
	public int solution(String s) {
		String[] str = s.split("");
		List<String> splitStr = new ArrayList<>();

		for (int i = 0; i < str.length; i++) {
			String x = str[i];

			if (x.equals("0")) { // 이미 분리한 문자열인 경우
				continue;
			}

			int xCount = 0; // x 횟수
			int notXCount = 0; // x가 아닌 횟수
			for (int j = 0; j < str.length; j++) {
				String z = str[j];

				if (z.equals("0")) { // 이미 분리한 문자열인 경우
					continue;
				}

				if (x.equals(z)) { // x와 동일한 경우
					xCount++;
				} else { // x와 다른 경우
					notXCount++;
				}

				if (xCount == notXCount) { // x와 x가 아닌 다른 글자들이 나온 횟수가 같은 경우
					splitStr.add(s.substring(i, j + 1));
					int k = i;
					while (k <= j) {
						str[k] = "0";
						k++;
					}
					break;
				}
			}

			if (i == str.length - 1) { // 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없는 경우
				if (xCount != 0 || notXCount != 0) { // 두 횟수중 한 횟수라도 체크가 된 경우
					splitStr.add(s.substring(i, str.length));
				}
			}
		}

		return splitStr.size();
	}
}

public class Lv1_stringDivision {
	public static void main(String[] args) {
		String s = "abracadabra";
		int ans = new StringDivision().solution(s);
		System.out.println(ans);
	}
}
