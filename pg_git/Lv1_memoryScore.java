package pg_git;

import java.util.HashMap;
import java.util.Map;

class MemoryScore {
	public int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];
		Map<String, Integer> score = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			score.put(name[i], yearning[i]);
		}

		int j = 0;
		for (String[] p : photo) {
			int sum = 0;
			for (int i = 0; i < p.length; i++) {
				if(score.get(p[i]) != null) {
					sum += score.get(p[i]);					
				}
			}
			answer[j] = sum;
			j++;
		}

		return answer;
	}
}

public class Lv1_memoryScore {
	public static void main(String[] args) {
		String[] name = { "may", "kein", "kain", "radi" };
		int[] yearning = { 5, 10, 1, 3 };
		String[][] photo = { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" },
				{ "kon", "kain", "may", "coni" } };

		int[] ans = new MemoryScore().solution(name, yearning, photo);
		for (int a : ans) {
			System.out.print(a+" ");
		}
	}
}
