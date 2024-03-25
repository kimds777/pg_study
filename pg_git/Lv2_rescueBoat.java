package pg_git;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class RescueBoat { // Deque 활용!!
	public int solution(int[] people, int limit) {

		Arrays.sort(people); // 무인도에 갇힌 사람들 몸무게 배열을 오름차순으로 정렬

		Deque<Integer> pp = new ArrayDeque<>(); // 가장 무거운 사람과 가장 가벼운 사람을 가져올 수 있도록 Deque 사용
		for (int p : people) { // 오름차순으로 정렬된 몸무게를 Deque에 넣는다.
			pp.add(p);
		}

		int numberOfRescueBoat = 0; // 필요한 구명보트 개수

		while (!pp.isEmpty()) { // Deque가 비어있는 않는 경우
			int weight = pp.pollLast(); // 가장 무거운 몸무게를 Deque에서 추출?하고 삭제

			// Deque에 몸무게가 1개 이상있고 
			// 가장 무거운 몸무게 + 가장 가벼운 몸무게가 무게 제한보다 같거나 작은 경우
			if (pp.size() >= 1 && weight + pp.peekFirst() <= limit) { 
				pp.pollFirst(); // 가장 가벼운 몸무게를 삭제
			}

			numberOfRescueBoat++; // 구명보트 개수를 1씩 증가시킨다
		}

		return numberOfRescueBoat;
	}
}

public class Lv2_rescueBoat {
	public static void main(String[] args) {
		int[] people = { 70, 50, 80, 50 };
		int limit = 100;

		RescueBoat rb = new RescueBoat();
		System.out.println(rb.solution(people, limit));
	}
}
