package pg_git;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class kthNumber {
	public int[] solution(int[] array, int[][] commands) {
		int leng = commands.length;
		int i = 0;
		int[] answer = new int[leng];
		for (int[] com : commands) {
			List<Integer> intList = new ArrayList<>();
			for (int j = com[0]; j <= com[1]; j++) {
				intList.add(array[j-1]);
			}
			Collections.sort(intList);
			answer[i] = intList.get(com[2]-1);
			i++;
		}

		return answer;
	}
}

public class Lv1_kthNumber {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] comm = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] ans = new kthNumber().solution(arr, comm);
		for(int a : ans) {
			System.out.print(a+" ");
		}

	}
}
