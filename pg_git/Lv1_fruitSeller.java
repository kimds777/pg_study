package pg_git;

import java.util.Arrays;

class FruitSeller {
	public int solution(int k, int m, int[] score) {
		int answer = 0;

		Arrays.sort(score);
		int leng = score.length - 1;

		while (leng >= m - 1) {

			int min = k;
			for (int i = 0; i < m; i++) {
				if (min > score[leng]) {
					min = score[leng];
				}
				leng--;
			}
			answer += min * m;
		}

		return answer;
	}
}

public class Lv1_fruitSeller {
	public static void main(String[] args) {
		int k = 3;
		int m = 4;
		int[] score = { 1, 2, 3, 1, 2, 3, 1 };
		int ans = new FruitSeller().solution(k, m, score);
		System.out.println("===");
		System.out.println(ans);
	}
}
