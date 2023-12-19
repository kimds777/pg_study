package pg_git;

import java.util.HashMap;
import java.util.Map;

class NotCompletedAFullRace {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Map<String, Integer> checkPlayer = new HashMap<>();

		for (String c : completion) { // 완주한 선수를 HashMap에 담는다.
			if (!checkPlayer.containsKey(c)) { // HashMap에 들어있지 않는 선수인 경우 
				checkPlayer.put(c, 0); // 0을 초기값으로 설정
			}
			checkPlayer.put(c, checkPlayer.get(c) + 1); // 선수 이름으로 value을 가져와 1씩 더해준다. 
		}

		for (String p : participant) { 
			if (checkPlayer.containsKey(p) && checkPlayer.get(p) != 0) { // 참여한 선수중 완주한 선수 map에 들어가 있으며, value값이 0이 아닌 경우
				checkPlayer.put(p, checkPlayer.get(p) - 1); // 선수 이름으로 value을 가져와 1씩 빼준다. 
				
			} else {// map에 들어있지않거나, value값이 0인 경우
				answer = p; 
				break;
			}
		}

		return answer;
	}
}

public class Lv1_notCompletedAFullRace {
	public static void main(String[] args) {
		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };

		String ans = new NotCompletedAFullRace().solution(participant, completion);
		System.out.println(ans);
	}
}
