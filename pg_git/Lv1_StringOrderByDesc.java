package pg_git;

import java.util.Arrays;
import java.util.Collections;

public class Lv1_StringOrderByDesc {
	public String solution(String s) {

		Integer[] arr = new Integer[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = (int) s.charAt(i);
		}

		Arrays.sort(arr, Collections.reverseOrder());

		char[] answer = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			int temp = (int) arr[i];
			answer[i] = (char) temp;
		}

		return String.valueOf(answer);
	}

	public static void main(String[] args) {
		Lv1_StringOrderByDesc sod = new Lv1_StringOrderByDesc();
		System.out.println(sod.solution("Zbcdefg"));
	}
}
