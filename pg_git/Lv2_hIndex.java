package pg_git;


import java.util.Arrays;

public class Lv2_hIndex {
    public static int solution(int[] citations){
        Arrays.sort(citations);

        int answer = citations.length;
        for(int c : citations){
            if(c >= answer){
                break;
            }else{
                answer--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }
}
