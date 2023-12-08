package pg_git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NumberMate {// 시간초과뜸! 수정필요!
	public String solution(String X, String Y) {
		String answer = "-1";
		List<Character> mate = new ArrayList<>();

		List<Character> y = new ArrayList<>();
        for (char yc : Y.toCharArray()) {
            y.add(yc);
        }

		for (char xx : X.toCharArray()) {
			int yIndex = y.indexOf(xx);

			if (yIndex != -1) {
				mate.add(xx);
				y.remove(yIndex);
				continue;
			}
		}

		if (mate.size() > 0) {

			Collections.sort(mate, Comparator.reverseOrder());

			if (mate.get(0).equals('0')) {
				answer = "0";
			} else {
				StringBuilder sb = new StringBuilder();
				for (char m : mate) {
					sb.append(m);
				}

				answer = sb.toString();
			}

		}

		return answer;
	}
}

public class Lv1_numberMate {
	public static void main(String[] args) {
		String X = "100";
		String Y = "2345";
		String ans = new NumberMate().solution(X, Y);

		System.out.println(ans);
	}
}
