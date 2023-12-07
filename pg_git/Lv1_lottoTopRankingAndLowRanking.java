package pg_git;

import java.util.HashMap;
import java.util.Map;

class LottoTopRankingAndLowRanking {
	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		Map<Integer, Integer> ranking = new HashMap<>();
		ranking.put(6, 1);
		ranking.put(5, 2);
		ranking.put(4, 3);
		ranking.put(3, 4);
		ranking.put(2, 5);

		int zeroCount = 0, sameCount = 0;
		for (int l : lottos) {
			if (l == 0) {
				zeroCount++;
				continue;
			}
			for (int w : win_nums) {

				if (l == w) {
					sameCount++;
					continue;
				}
			}
		}

		answer[0] += zeroCount + sameCount;
		answer[1] += sameCount;

		for (int i = 0; i < answer.length; i++) {
			if (!ranking.containsKey(answer[i])) {
				answer[i] = 6;
			} else {
				answer[i] = ranking.get(answer[i]);
			}
		}

		return answer;
	}
}

public class Lv1_lottoTopRankingAndLowRanking {
	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };
		int[] ans = new LottoTopRankingAndLowRanking().solution(lottos, win_nums);

		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}
