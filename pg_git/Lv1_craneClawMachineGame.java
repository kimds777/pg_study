package pg_git;

import java.util.Stack;

class CraneClawMachineGame {
	public int solution(int[][] board, int[] moves) {
		Stack<Integer> basket = new Stack<>();
		
		int answer = 0;
		for (int m : moves) {
			for (int b = 0; b < board.length; b++) {
				int number = board[b][m - 1];
				if (number != 0) {
					if (!basket.isEmpty() && basket.peek() == number) { // 바구니가 비어있지 않고 바구니 가장 상단의 값과 number가 동일한 경우
						basket.pop(); // 상단 값을 제거
						answer += 2; // number와 상단값이 동일하니 2를 더해준다.
					} else { // 바구니가 비어있거나 상단의 값과 number가 다른 경우
						basket.push(number); // 바구니에 number를 추가한다.
					}
					board[b][m - 1] = 0; // board배열에서 number를 0으로 처리해 지운다.
					break;
				}
			}
		}
		return answer;
	}
}

public class Lv1_craneClawMachineGame {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		int ans = new CraneClawMachineGame().solution(board, moves);
		System.out.println(ans);
	}
}
