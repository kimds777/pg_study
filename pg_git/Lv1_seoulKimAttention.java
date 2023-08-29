package pg_git;

import java.util.Arrays;

public class Lv1_seoulKimAttention {
	// for문 풀이!
    public String solution(String[] seoul) {
    	String answer = "";
    	for(int s = 0; s<seoul.length; s++) {
    		if (seoul[s].equals("Kim")) {
				answer = "김서방은 "+s+"에 있다";
			}
    	}
		return answer;
    }
    
    // index 활용 풀이!
    public String indexOfArrays(String[] seoul) {
    	int index = Arrays.asList(seoul).indexOf("Kim");
    	return "김서방은 "+index+"에 있다";
    }
}
