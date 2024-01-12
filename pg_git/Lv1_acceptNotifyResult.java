package pg_git;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

class AcceptNotifyResult {
	public int[] solution(String[] id_list, String[] report, int k) {
		Map<String, Integer> checkNotify = new HashMap<>(); // 신고당한 유저 -> key, 신고당한 횟수 -> value
		Map<String, HashSet<String>> checkReporter = new HashMap<>(); // 신고당한 유저 -> key, 신고 유저들 -> value

		for (String r : report) {
			StringTokenizer st = new StringTokenizer(r, " "); // 신고리스트를 " "로 구분하여 신고유저와 신고당한 유저로 분리.
			String reporterUser = st.nextToken(); // 신고유저
			String notifyUser = st.nextToken(); // 신고당한 유저

			if (!checkReporter.containsKey(notifyUser)) { // checkReporter에 신고당한 유저가 없는 경우
				checkReporter.put(notifyUser, new HashSet<>()); // checkReporter에 신고당한 유저를 넣어주고 신고 유저를 담을 HashSet을 생성
			}

			if (checkReporter.get(notifyUser).add(reporterUser)) { // checkReporter에 신고당한 유저의 HashSet에 신고유저가 중복되지 않는 경우
				checkMap(checkNotify, notifyUser); // checkNotify에 신고당한 유저의 신고횟수를 1씩 증가시킨다.
			}

		}

		Map<String, Integer> sendEmail = new HashMap<>(); // 신고 처리 결과 메일을 받을 신고 유저(key)와 메일갯수(value)를 담을 Map
		for (String key : checkNotify.keySet()) {
			if (checkNotify.get(key) >= k) { // 신고당한 유저의 신고횟수가 최대신고횟수인 k이상인 경우

				Iterator iter = checkReporter.get(key).iterator(); // HashSet을 Iterator로 변환하여 값을 출력한다.
				while (iter.hasNext()) { // Iterator에 출력값이 남아있을때 까지 반복
					String user = (String) iter.next();
					checkMap(sendEmail, user); // sendEmail에 결과 메일을 받을 신고 유저의 메일갯수를 1씩 증가시킨다.
				}
			}
		}

		int[] answer = new int[id_list.length];
		for (int i = 0; i < answer.length; i++) {
			if(!sendEmail.containsKey(id_list[i])) { // sendEmail에 신고 유저의 이름이 없는 경우
				answer[i] = 0; // 메일갯수 0을 배열에 담는다.
			}else { // sendEmail에 신고 유저의 이름이 있는 경우
				answer[i] = sendEmail.get(id_list[i]);	 //	메일갯수를 	sendEmail에서 가져와 배열에 담는다.
			}
		}
		return answer;
	}
	
	private void checkMap(Map<String,Integer> map, String key) {
		if (!map.containsKey(key)) { // map에 key가 없는 경우
			map.put(key, 0); // key와 value을 map에 담아준다.
		}
		map.replace(key, map.get(key) + 1); // key로 value을 조회하여 값을 변경해준다.
	}
}

public class Lv1_acceptNotifyResult {
	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;

		int[] ans = new AcceptNotifyResult().solution(id_list, report, k);
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}
