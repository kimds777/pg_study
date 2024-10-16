package pg_git;

import java.util.*;

class ChoosingTangerines {
    public static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> tangerineMap = new HashMap<>();

        for (int t : tangerine) {
            if (!tangerineMap.containsKey(t)) {
                tangerineMap.put(t, 0);
            }

            tangerineMap.put(t, tangerineMap.get(t) + 1);
        }

        List<Integer> keySet = new ArrayList<>(tangerineMap.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return tangerineMap.get(o2).compareTo(tangerineMap.get(o1));
            }
        });

        int answer = 0;

        for(int key : keySet){

            k -= tangerineMap.get(key);
            answer++;

            if(k <= 0){
                break;
            }
        }

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
