package pg_git;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class NumberMate {
	public String solution(String X, String Y) {
		String answer = "-1";

		String[] number = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		List<String> mate = new ArrayList<>();

		List<String> x = new ArrayList(Arrays.asList(X.split("")));
		List<String> y = new ArrayList(Arrays.asList(Y.split("")));

		Collections.sort(x);
		Collections.sort(y);
		
		for (String n : number) {
			int xIndex = x.lastIndexOf(n);
			int yIndex = y.lastIndexOf(n);

			if (yIndex != -1 && xIndex != -1) { //x, y리스트 모두 n문자가 존재하는 경우 실행
				int repeatNumber = xIndex; //기본값을 xIndex로 설정

				if (xIndex > yIndex) { //yIndex가 더 작을 경우 변경
					repeatNumber = yIndex;
				}

				for (int i = 0; i <= repeatNumber; i++) { //작은 index만큼 List에 추가
					mate.add(n);
				}
			}
			List<String> removeStringAll = new ArrayList<>(); //x, y리스트에서 삭제할 문자를 리스트화
			removeStringAll.add(n);

			if (xIndex != -1) { //x에 n문자가 존재하는 경우 실행
				x.removeAll(removeStringAll); //x리스트에서 n문자 전체 삭제
			}
			if (yIndex != -1) { //y에 n문자가 존재하는 경우 실행
				y.removeAll(removeStringAll); //y리스트에서 n문자 전체 삭제
			}

		}

		if (mate.size() > 0) { //리스트에 값이 존재하는 경우

			Collections.sort(mate, Comparator.reverseOrder()); //리스트 역정렬

			if (mate.get(0).equals("0")) { //리스트 제일 큰값이 0인 경우
				answer = "0";
			} else {
				StringBuilder sb = new StringBuilder();
				for (String m : mate) {
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
		String X = "12321";
		String Y = "423531";
		String ans = new NumberMate().solution(X, Y);

		System.out.println(ans);
	}
}
