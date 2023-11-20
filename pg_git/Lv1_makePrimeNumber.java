package pg_git;

import java.util.Arrays;

class MakePrimeNumber {
	public int solution(int[] nums) {
		int answer = 0;
		int checkNumber;
		int cnt = 0;
		Arrays.sort(nums);
		int leng = nums.length;

		if (leng == 3) {
			checkNumber = nums[0] + nums[1] + nums[2];
			for (int i = 2; i < checkNumber; i++) {
				if (checkNumber % i == 0) {
					break;
				}
				cnt++;
			}

			if (cnt == checkNumber - 2) {
				answer++;
			}

		} else {
			for (int i = 0; i < leng - 2; i++) {
				for (int j = i + 1; j < leng - 1; j++) {
					for (int k = j + 1; k < leng; k++) {
						checkNumber = nums[i] + nums[j] + nums[k];
						cnt = 0;
						for (int l = 2; l < checkNumber; l++) {

							if (checkNumber % l == 0) {
								break;
							}
							cnt++;
						}
						if (cnt == checkNumber - 2) {
							answer++;
						}
					}
				}
			}
		}

		return answer;
	}
}

public class Lv1_makePrimeNumber {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		int ans = new MakePrimeNumber().solution(nums);
		System.out.println("---");
		System.out.println(ans);
	}
}
