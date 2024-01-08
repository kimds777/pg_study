package pg_git;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class PersonalInformation {
	public int[] solution(String today, String[] terms, String[] privacies) {
		Map<String, Integer> termsList = new HashMap<>(); // 약관 종류(key)와 유효기간(value)을 저장할 Map 생성

		StringTokenizer st = null;
		for (String t : terms) { // 약관 종류와 유효기간을 " "로 구분하여 termsList에 넣는다.
			st = new StringTokenizer(t, " ");
			termsList.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}

		int[] todayIntArr = setArr(st, ".", today); // 오늘 날짜를 "."로 구분하여 todayIntArr에 넣는다.

		List<Integer> saveIndex = new ArrayList<>(); // 소멸할 privacies의 index를 저장할 List 생성
		for (int p = 0; p < privacies.length; p++) {
			st = new StringTokenizer(privacies[p], " "); // privacies[p]를 " "로 구분하여 날짜와 약관 종류로 나눈다.
			
			String date = st.nextToken(); // date에 날짜를 String으로 넣는다.
			int month = termsList.get(st.nextToken()); // 약관 종류로 termsList에서 유효기간을 가져와 month에 넣는다.

			int[] temp = setArr(st, ".", date); // date를 "."로 구분하여 temp에 넣는다.
			temp[1] += month; // [0]은 년, [1]은 월, [2]는 일 -> temp[1]에 유효기간을 더해준다.

			monthCheck(temp); // 달이 12보다 큰 경우 12로 나누어 년에 더해준다. -> 달이 12의 배수인 경우도 처리.
			extinctionCheck(saveIndex, temp, todayIntArr, p); // 년, 월, 일을 비교하여 소멸정보의 index를 saveIndex에 넣어준다.
		}

		int[] answer = new int[saveIndex.size()];
		for (int s = 0; s < saveIndex.size(); s++) { // saveIndex에 저장된 index를 answer에 넣어준다.
			answer[s] = saveIndex.get(s);
		}

		return answer;
	}

	private int[] setArr(StringTokenizer st, String regex, String str) {
		st = new StringTokenizer(str, regex);

		int[] arr = new int[st.countTokens()];
		for (int a = 0; a < arr.length; a++) {
			arr[a] = Integer.parseInt(st.nextToken());
		}

		return arr;
	}

	private void monthCheck(int[] arr) {
		if (arr[1] > 12) {
			if (arr[1] % 12 != 0) {
				arr[0] += arr[1] / 12;
				arr[1] = arr[1] % 12;
			} else {
				arr[0] += arr[1] / 12 - 1;
				arr[1] = 12;
			}
		}
	}

	private void extinctionCheck(List<Integer> list, int[] arr1, int[] arr2, int index) {
		if (arr1[0] < arr2[0]) {
			list.add(index + 1);

		} else if (arr1[0] == arr2[0]) {
			if (arr1[1] < arr2[1]) {
				list.add(index + 1);

			} else if (arr1[1] == arr2[1]) {
				if (arr1[2] <= arr2[2]) {
					list.add(index + 1);

				}
			}
		}
	}
}

public class Lv1_personalInformationCollectionExpirationDate {
	public static void main(String[] args) {
		String today = "2009.12.31";
		String[] terms = { "A 13" };
		String[] privacies = { "2008.11.03 A" };

		int[] ans = new PersonalInformation().solution(today, terms, privacies);
		for (int a : ans) {
			System.out.print(a + " ");
		}
	}
}
