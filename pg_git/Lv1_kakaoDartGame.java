package pg_git;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class KakaoDartGame {
	public int solution(String dartResult) {
		int answer = 0;
		char[] dart = dartResult.toCharArray();
		int leng = dart.length;

		Map<Character, Integer> pow = new HashMap<>();
		pow.put('S', 1);
		pow.put('D', 2);
		pow.put('T', 3);

		List<Integer> dartScore = new ArrayList<>();
		for (int i = 0; i < leng; i++) {
			int index = dartScore.size() - 1;
			if (pow.containsKey(dart[i])) {
				dartScore.set(index, (int) Math.pow(dartScore.get(index), pow.get(dart[i])));
			} else {
				if (dart[i] == '*') {
					if (index != 0) {
						int preIndex = index - 1;
						dartScore.set(preIndex, dartScore.get(preIndex) * 2);
					}
					dartScore.set(index, dartScore.get(index) * 2);
				} else if (dart[i] == '#') {
					dartScore.set(index, dartScore.get(index) * -1);
				} else {
					if (i > 0 && dart[i - 1] == '1' && dart[i] == '0') {
						dartScore.set(index, 10);
					} else {
						dartScore.add(dart[i] - 48);
					}
				}
			}
		}
		for (int d : dartScore) {
			answer += d;
		}

		return answer;
	}
}

public class Lv1_kakaoDartGame {
	public static void main(String[] args) {
		String dartResult = "1D2S#10S";
		int ans = new KakaoDartGame().solution(dartResult);
		System.out.println(ans);
	}
}
