package pg_git;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class PushKeypad {
	public String solution(int[] numbers, String hand) {
		Set<Integer> leftThumb = new HashSet<>(Arrays.asList(1, 4, 7));
		Set<Integer> rightThumb = new HashSet<>(Arrays.asList(3, 6, 9));
		int[] currentPushKeypad = { 10, 12 };

		StringBuilder sb = new StringBuilder();
		for (int n : numbers) {

			if (leftThumb.contains(n)) { // 왼쪽열 숫자인 경우
				appendString(currentPushKeypad, sb, n, 0, "L"); // 왼쪽 엄지 숫자를 n으로 변경한후 sb에 L를 넣는다.
			} else if (rightThumb.contains(n)) { // 오른쪽열 숫자인 경우
				appendString(currentPushKeypad, sb, n, 1, "R"); // 오른쪽 엄지 숫자를 n으로 변경한후 sb에 R를 넣는다.
			} else {
				if (n == 0) { // numbers의 숫자가 0인 경우
					n = 11; // 11로 바꿔준다
				}

				int leftDistance = Math.abs(currentPushKeypad[0] - n); // 왼쪽 엄지 숫자와 n을 빼고 Math.abs를 사용해 절대값으로 변경 
				int rightDistance = Math.abs(currentPushKeypad[1] - n); // 오른쪽 엄지 숫자와 n을 빼고 Math.abs를 사용해 절대값으로 변경 

				leftDistance = (leftDistance / 3) + (leftDistance % 3); // 세로간격 -> (leftDistance / 3), 가로간격 -> (leftDistance % 3)
				rightDistance = (rightDistance / 3) + (rightDistance % 3); // 세로간격 -> (rightDistance / 3), 가로간격 -> (rightDistance % 3)

				if (leftDistance == rightDistance) { // 오른쪽 간격, 왼쪽 간격이 동일한 경우
					if (hand.equals("right")) { // 오른손 잡이인 경우
						appendString(currentPushKeypad, sb, n, 1, "R");
					} else { // 왼손 잡이인 경우
						appendString(currentPushKeypad, sb, n, 0, "L");
					}
				} else if (leftDistance > rightDistance) { // 왼쪽 간격이 더 큰 경우
					appendString(currentPushKeypad, sb, n, 1, "R");
				} else { // 오른쪽 간격이 더 큰 경우
					appendString(currentPushKeypad, sb, n, 0, "L");
				}
			}
		}

		return sb.toString();
	}

	public void appendString(int[] currentPushKeypad, StringBuilder sb, int number, int index, String direction) {
		currentPushKeypad[index] = number;
		sb.append(direction);
	}
}

public class Lv1_pushKeypad {
	public static void main(String[] args) {
		int[] number = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";

		String ans = new PushKeypad().solution(number, hand);
		System.out.println(ans);
	}
}
