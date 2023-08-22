package pg_git;

public class Lv1_pycount {
	boolean solution(String s) {
		char[] sArr = s.toCharArray();
		int p=0;
		int y=0;
		for(int i=0;i<sArr.length;i++) {
			if(sArr[i]=='p') p+=1;
			else if(sArr[i]=='y') y+=1;
		}
		if(p==y) return true;
		else return false;
	}
}
