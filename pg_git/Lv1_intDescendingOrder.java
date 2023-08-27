package pg_git;

import java.util.*;

public class Lv1_intDescendingOrder {
    public long solution(long n) {
    	
    	String[] arr = String.valueOf(n).split("");    	
    	 Arrays.sort(arr, Collections.reverseOrder());
    	
    	 String sortedNumberStr = String.join("", arr);
    	
        return Long.parseLong(sortedNumberStr);
        
    }
}