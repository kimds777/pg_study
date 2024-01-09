package pg_git;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class WalkInThePark {
	public int[] solution(String[] park, String[] routes) {
		Map<String, Integer> direction = new HashMap<>();
		direction.put("N", -1); // 북
		direction.put("S", 1); // 남
		direction.put("W", -1); // 서
		direction.put("E", 1); // 동

		int[] answer = new int[2];
		for (int p = 0; p < park.length; p++) { // park[]에서 시작 지점 찾기
			if (park[p].contains("S")) { // 문자에 S가 포함된 경우
				answer[0] = p; // p를 answer[0]에 저장
				answer[1] = park[p].indexOf("S"); // park[p]의 문자열에 "S"의 index를 찾아 answer[1]에 저장
			}
		}

		StringTokenizer st = null;
		for (String r : routes) {
			st = new StringTokenizer(r, " "); //route를 " "로 구분해서 op와 move로 분리
			String op = st.nextToken();
			int move = direction.get(op) * Integer.parseInt(st.nextToken());

			if (op.equals("N") || op.equals("S")) { // 행을 이동해야하는 경우
				int row = answer[0] + move;
				if (row >= 0 && row <= park.length - 1) { // 목적지가 배열에 벗어나지 않는 경우
					boolean checkObstacle = checkRoad(park, answer, 0, row); // 기본값은 false! 목적지로 이동중 장애물을 만나는지 검사

					if (!checkObstacle) { // 장애물이 없는 경우
						char checkPark = park[row].charAt(answer[1]);
						checkAndAddValue(answer, row, checkPark, 0); // 목적지에 장애물이 있는지 검사후 없다면 배열에 값을 넣는다.
					}
				}
			} else { // 열을 이동해야하는 경우
				int col = answer[1] + move;
				if (col >= 0 && col <= park[0].length() - 1) { // 목적지가 배열에 벗어나지 않는 경우
					boolean checkObstacle = checkRoad(park, answer, 1, col); // 기본값은 false! 목적지로 이동중 장애물을 만나는지 검사

					if (!checkObstacle) { // 장애물이 없는 경우
						char checkPark = park[answer[0]].charAt(col); 
						checkAndAddValue(answer, col, checkPark, 1); // 목적지에 장애물이 있는지 검사후 없다면 배열에 값을 넣는다.
					}
				}
			}

		}
		return answer;
	}

	private void checkAndAddValue(int[] arr, int value, char check, int index) {
		if (check != 'X') { // 목적지에 장애물이 없는 경우
			arr[index] = value; // 값을 넣어준다.
		}
	}

	private boolean checkRoad(String[] park, int[] arr, int index, int value) {
		if (index == 1) { // 열을 탐색하는 경우
			if (value > arr[index]) { // 기존값보다 value이 큰 경우, 기존값에서 value까지 값을 증가 시키면서 탐색
				for (int a = arr[index]; a < value; a++) { 
					if (park[arr[0]].charAt(a) == 'X') {
						return true;
					}
				}
			}else { // 기존값보다 value이 작은 경우, 기존값에서 value까지 값을 감소 시키면서 탐색
				for (int a = arr[index]; a >= value; a--) {
					if (park[arr[0]].charAt(a) == 'X') {
						return true;
					}
				}
			}
		} else { // 행을 탐색하는 경우
			if (value > arr[index]) { // 기존값보다 value이 큰 경우, 기존값에서 value까지 값을 증가 시키면서 탐색
				for (int a = arr[index]; a < value; a++) {
					if (park[a].charAt(arr[1]) == 'X') {
						return true;
					}
				}				
			}else { // 기존값보다 value이 작은 경우, 기존값에서 value까지 값을 감소 시키면서 탐색
				for (int a = arr[index]; a >= value; a--) {
					if (park[a].charAt(arr[1]) == 'X') {
						return true;
					}
				}
			}
		}

		return false;
	}
}

public class Lv1_walkInThePark {
	public static void main(String[] args) {
		String[] park = { "SOOXO", "OOOXO", "OXOOO", "XOOOO" };
		String[] routes = { "E 2", "S 2", "W 2", "S 1", "W 1" };

		int[] ans = new WalkInThePark().solution(park, routes);
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}
