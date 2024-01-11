package pg_git;

import java.util.HashMap;
import java.util.Map;

class RunRace {
	public String[] solution(String[] players, String[] callings) {
		Map<String, Integer> checkPlayers = new HashMap<>(); // HashMap을 생성하여 현재 플레이어의 이름과 순위를 저장한다.
		for (int p = 0; p < players.length; p++) {
			checkPlayers.put(players[p], p); // players[p] -> key, p-> value
		}

		for (String c : callings) { // 추월한 선수의 이름을 호명한다.
			int currentIndex = checkPlayers.get(c); // 추월한 선수의 추월전 순위를 HashMap에서 가져와 저장
			String outrunPlayer = players[currentIndex - 1]; // 추월 당한 선수의 이름을 players에서 가져와 저장

			checkPlayers.replace(c, currentIndex - 1); // HashMap에 추월한 선수의 순위를 변경
			checkPlayers.replace(outrunPlayer, currentIndex); // HashMap에 추월 당한 선수의 순위를 변경

			players[currentIndex - 1] = c; // 추월한 선수의 이름을 추월 당한 선수의 index로 옮긴다. 
			players[currentIndex] = outrunPlayer; // 추월 당한 선수의 이름을 추월한 선수의 index로 옮긴다. 
		}

		return players;
	}

//	시간 초과!
//	public String[] solution(String[] players, String[] callings) {
//
//		for (String c : callings) { // 추월한 선수의 이름을 호명한다.
//			for (int p = 0; p < players.length; p++) { 
//				if (c.equals(players[p])) { // 호명한 선수 이름과 players[p]가 동일한 경우 
//					String temp = players[p]; // players[p]를 임시로 저장
//					players[p] = players[p-1]; // 호명한 선수의 index에 추월 당한 선수의 이름을 저장
//					players[p-1] = temp; // 추월 당한 선수의 index에 호명한 선수의 이름을 저장 
//					break;
//				}
//			}
//		}
//
//		return players;
//	}
}

public class Lv1_runRace {
	public static void main(String[] args) {
		String[] players = { "mumu", "soe", "poe", "kai", "mine" };
		String[] callings = { "kai", "kai", "mine", "mine" };

		String[] ans = new RunRace().solution(players, callings);
		for (String a : ans) {
			System.out.print(a + " ");
		}
	}
}
