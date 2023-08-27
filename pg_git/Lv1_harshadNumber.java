package pg_git;

public class Lv1_harshadNumber {
	public boolean solution(int x) {
		
		if(x>=10) {
			int total = 0;
			int mod = x;
			
			while(mod>0) {
				total += mod%10;
				mod /=10;
			}
			
			int result = x % total;
			
			if (result == 0) {
				return true;
			} else {
				return false;
			}		
			
		}else {
			return true;
		}
	}
}
