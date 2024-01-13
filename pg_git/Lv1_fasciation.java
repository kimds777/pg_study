package pg_git;

class Fasciation {
	public int solution(int[] bandage, int health, int[][] attacks) {
		int time = 0;
		int maxHealth = health; // 기본 체력값을 저장 
		
		for (int[] a : attacks) {
			if (health < maxHealth) { // 체력이 기본 체력보다 적은 경우
				
				int timeOfBeforeAttack = a[0] - time; // 공격시간 - 현재시간 -> 공격하기 전 남은 시간
				if (timeOfBeforeAttack > bandage[0]) { // 공격하기 전 시간이 시전 시간보다 큰 경우
					
					int numberOfTreatments = timeOfBeforeAttack / bandage[0]; // 회복을 몇번이나 할수있는지 계산하여 담는다
					if (timeOfBeforeAttack % bandage[0] == 0) { // 나머지가 0인 경우 
						//공격시간에는 회복을 할 수 없기 때문에 나머지가 최소 1이상이여야 한다.
						numberOfTreatments--; // 공격시간을 제외해야하기 때문에 1을 빼준다.
					}
					health += (bandage[0] * bandage[1] + bandage[2]) * numberOfTreatments; // (시전시간 * 초당 회복량 + 추가회복량) * 시전 횟수
					
				} else if (timeOfBeforeAttack > 1) { // 공격하기 전 시간이 2이상인 경우					
					health += bandage[1] * (timeOfBeforeAttack - 1); // 공격시간에는 회복을 할 수 없기 때문에 timeOfBeforeAttack에서 1을 빼준다.
				}
				
				if (health > maxHealth) { // 치료한 체력이 기본 체력보다 큰 경우
					health = maxHealth; // 체력을 기본 체력으로 바꿔준다.
				}
			}

			time = a[0]; // time을 공격 시간으로 바꿔준다.
			health -= a[1]; // 체력에서 피해량을 빼준다.
			
			if (health <= 0) { // 공격 진행중 공격 받은 체력이 0이하인 경우
				return -1; // 캐릭터가 죽었으므로 -1을 리턴해준다. 
			}
		}

		if (health <= 0) { // 공격이 끝난후 체력이 0이하인 경우
			return -1; // 캐릭터가 죽었으므로 -1을 리턴해준다. 
		}

		return health;
	}
	
}

public class Lv1_fasciation {
	public static void main(String[] args) {
		int[] bandage = { 4, 2, 7 };
		int health = 20;
		int[][] attacks = { { 1, 15 }, { 5, 16 }, { 8, 6 } };

		int ans = new Fasciation().solution(bandage, health, attacks);
		System.out.println(ans);
	}
}
