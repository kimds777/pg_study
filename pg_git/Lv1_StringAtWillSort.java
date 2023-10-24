package pg_git;

import java.util.Arrays;
import java.util.Comparator;

class StringAtWillSort {
    public String[] solution(String[] strings, int n) {
        // 문자열 배열(strings)을 주어진 n번째 문자를 기준으로 정렬
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 문자열 a와 문자열 b의 n번째 문자를 가져옴
                char charA = a.charAt(n);
                char charB = b.charAt(n);
                
                // 두 문자가 같은 경우, 문자열을 사전 순으로 정렬
                if (charA == charB) {
                    return a.compareTo(b); // 문자열 a와 b를 비교하여 정렬
                }
                
                // 두 문자가 다른 경우, n번째 문자를 기준으로 정렬합
                return charA - charB;
            }
        });

        // 정렬된 문자열 배열을 반환
        return strings;
    }
}


public class Lv1_StringAtWillSort {
	public static void main(String[] args) {
		String[] str = { "abce", "abcd", "cdx" };
		int n = 2;
		String[] s = new StringAtWillSort().solution(str, n);
		
		for (String ss : s) {
			System.out.print(ss + " ");
		}
	}
}
