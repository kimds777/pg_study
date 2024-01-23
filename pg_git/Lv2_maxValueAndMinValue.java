package pg_git;

import java.util.StringTokenizer;
import java.util.TreeSet;

class MaxValueAndMinValue {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		TreeSet<Integer> sSet = new TreeSet<>(); // 정렬, 검색, 범위검색에 유리한 TreeSet 사용!

		StringTokenizer st = new StringTokenizer(s, " "); //문자열 s를 공백(" ")으로 구분하여 분리
		while (st.hasMoreTokens()) {
			sSet.add(Integer.parseInt(st.nextToken())); // TreeSet에 정렬되면서 저장된다.
		}

		sb.append(sSet.first() + " " + sSet.last()); // 최솟값과 최대값을 sb에 저장

		return sb.toString();
	}
}

public class Lv2_maxValueAndMinValue {
	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";

		String ans = new MaxValueAndMinValue().solution(s);
		System.out.println(ans);
	}
}
