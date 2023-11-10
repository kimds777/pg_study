package pg_git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class TheHallOfFame { // 풀어야함
	public int[] solution(int k, int[] score) {
		List<Integer> scoreSort = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		k -= 1;
		
		for (int i = 0; i < score.length; i++) {
			scoreSort.add(score[i]);
			Collections.sort(scoreSort,Comparator.reverseOrder());
			
			int size = scoreSort.size()-1;
			if (size < k) {
				result.add(scoreSort.get(size));
			}else {
				result.add(scoreSort.get(k));
			}
		}

		int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
		return answer;
	}
}

public class Lv1_theHallOfFame_1 {
	public static void main(String[] args) {
		int[] score = { 10, 100, 20, 150, 1, 100, 200 };
		int[] ans = new TheHallOfFame().solution(3, score);
		for(int a : ans) {
			System.out.print(a+" ");
		}
	}
}
