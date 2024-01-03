package pg_git;

class NeighborRoom {
	public int solution(String[][] board, int h, int w) {
		int answer = 0;
		String mainColor = board[h][w]; // 지정된 칸의 컬러

		if (h != 0) { // h가 0이 아닌 경우
			if (mainColor.equals(board[h - 1][w])) { //mainColor와 비교해서 동일한 경우
				answer++; // answer를 1증가시킨다.
			}
		}

		if (board.length - 1 > h) { // h가 board의 길이보다 작은 경우
			if (mainColor.equals(board[h + 1][w])) {
				answer++;
			}
		}

		if (w != 0) { // w가 0이 아닌 경우
			if (mainColor.equals(board[h][w - 1])) {
				answer++;
			}
		}

		if (board[0].length - 1 > w) { //w가 board[0]의 길이보다 작은 경우
			if (mainColor.equals(board[h][w + 1])) {
				answer++;
			}
		}

		return answer;
	}
}

public class Lv1_neighborRoom {
	public static void main(String[] args) {
		String[][] board = { { "blue", "red", "orange", "red" }, { "red", "red", "blue", "orange" },
				{ "blue", "orange", "red", "red" }, { "orange", "orange", "red", "blue" } };
		int h = 1;
		int w = 1;

		int ans = new NeighborRoom().solution(board, h, w);
		System.out.println(ans);
	}
}
