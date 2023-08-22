package pg_git;

public class Lv1_naturalNubReverseArray {
    public int[] solution(long n) {
        int length =  Long.toString(n).length();
        int[] arr = new int[length];
        
        for(int i = 0; i<length; i++) {
        	arr[i] = (int) (n%10);
        	n /= 10; 
        }
        return arr;
    }
}
