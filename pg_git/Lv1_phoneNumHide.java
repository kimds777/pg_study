package pg_git;

import java.util.Iterator;

public class Lv1_phoneNumHide {
    public String solution(String phone_number) {
    	char[] pNum = phone_number.toCharArray();
        for(int i = 0; i<pNum.length-4; i++) {
        	pNum[i] = '*';
        }
        return String.valueOf(pNum);
    }
}
