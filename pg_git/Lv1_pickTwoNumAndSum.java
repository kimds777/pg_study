package pg_git;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class PickTwoNum {
	public int[] solution(int[] numbers) {
		Set<Integer> numberSum = new TreeSet<>();
		int leng = numbers.length;
		for (int i = 0; i < leng - 1; i++) {
			for (int j = i + 1; j < leng; j++) {
				numberSum.add(numbers[i] + numbers[j]);
			}
		}

		int[] answer = new int[numberSum.size()];
		Iterator<Integer> it = numberSum.iterator();
		int a = 0;
		while (it.hasNext()) {
			answer[a] = it.next();
			a++;
		}

		return answer;
	}
}

public class Lv1_pickTwoNumAndSum {
	public static void main(String[] args) {
		int[] numbers = { 5, 0, 2, 7 };
		int[] ans = new PickTwoNum().solution(numbers);
		for (int a : ans) {
			System.out.print(a);
		}
	}
}
