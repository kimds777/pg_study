package pg_git;

import java.util.Arrays;

class NMinimumCommonMultiple {
	public int solution(int[] arr) {
		Arrays.sort(arr); // arr배열에서 가장 큰 수를 통해 최소공배수를 구하기 위해 오른차순 정렬
		int cnt = 2; // 가장 큰 수에 곱할 수

		return gcd(arr, cnt);
	}

	private static int gcd(int[] arr, int cnt) {
		int number = arr[arr.length - 1] * cnt; // 배열에서 가장 큰 수와 cnt를 곱하여 가장 큰 숫자의 배수 생성
		for (int i = arr.length - 2; i >= 0; i--) { // 가장 큰 숫자를 제외한 나머지 숫자들
			if (number % arr[i] != 0) { // 가장 큰 숫자의 배수와 배열의 숫자가 공배수가 아닌 경우
				cnt++; // 곱할 수를 1씩 증가시킨다.
				return gcd(arr, cnt); // 재귀함수 활용
			}
			
			// else문 생략 -> 가장 큰 숫자의 배수와 배열의 모든 숫자가 공배수인 경우
		}

		return number;
	}
}

public class Lv2_nMinimumCommonMultiple {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 8, 14 };

		int ans = new NMinimumCommonMultiple().solution(arr);
		System.out.println(ans);
	}
}
