package pg_git;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Find {
	public int[] solution(int[] nm) {
		
		int[] answer = new int[nm.length];

		int n = nm[0];
		int m = nm[1];

		if (n > m) {
			int temp = n;
			n = m;
			m = temp;
		}

		for (int i = 1; i <= n; i++) { // 최대 공약수 구하기
			if (n % i == 0 && m % i == 0) {
				answer[0] = i;
			}
		}

		if (m % n == 0) { // 최소 공배수 구하기			
			answer[1] = m;
		} else {
				answer[1] = (m * n) / answer[0];
		}

		return answer;
	}
}

public class Lv1_maxCommonDivisorAndMinCommonMultiple {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nm = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		Find f = new Find();		
		int[] ans = f.solution(nm);
		
		for(int a : ans) {
			System.out.print(a+" ");			
		}
	}
}
