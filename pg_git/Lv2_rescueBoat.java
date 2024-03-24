package pg_git;

import java.util.Arrays;

class RescueBoat { // 효율성 테스트 시간초과..! 수정필요!
	public int solution(int[] people, int limit) {

		int numberOfRescueBoat = 0;
		Arrays.sort(people);

		for (int i = people.length - 1; i >= 0; i--) {
			if (people[i] == 0) {
				break;
			}

			if (i == 0) {
				System.out.println("check-1");
				numberOfRescueBoat++;
				break;
			}

			for (int j = 0; j < people.length; j++) {
				if (people[j] == 0) {
					continue;
				}

				if (people[i] + people[j] <= limit) {
					System.out.println("check-2 : " + people[i] + ", " + people[j]);
					people[j] = 0;
					break;
				}
			}

			people[i] = 0;
			numberOfRescueBoat++;
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
