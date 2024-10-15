package pg_git;

import java.util.HashMap;

class ChoosingTangerines {
    public static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> tangerineMap = new HashMap<>();

        for(int t : tangerine){
            if(!tangerineMap.containsKey(t)){
                tangerineMap.put(t,0);
            }

            tangerineMap.put(t, tangerineMap.get(t)+1);
        }


        int answer = 0;
        return answer;
    }
}
public class Lv2_choosingTangerines {
    public static void main(String[] args) {
        int[] tangerines = {1, 3, 2, 5, 4, 5, 2, 3};
        int answer = new ChoosingTangerines().solution(6, tangerines);
        System.out.println(answer);
    }
}
