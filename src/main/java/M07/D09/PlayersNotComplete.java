package M07.D09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/*
* 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
* 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
* 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
*
* 제한사항
* 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
* completion의 길이는 participant의 길이보다 1 작습니다.
* 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
* 참가자 중에는 동명이인이 있을 수 있습니다.
**
* participant	                                        completion	                             return
* ["leo", "kiki", "eden"]                            ["eden", "kiki"]                       	"leo"
* ["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
* ["mislav", "stanko", "mislav", "ana"]         	["stanko", "ana", "mislav"]             	"mislav"
 */
public class PlayersNotComplete {

    public static void main(String[] args) {
        PlayersNotComplete pnc = new PlayersNotComplete();
        String[] participant =
                //{"leo", "kiki", "eden"};
                {"stanko", "mislav", "ana","stanko"};
        String[] completion =
                //{"eden", "kiki"};
                {"stanko", "ana", "mislav"};
        System.out.println(pnc.solution(participant,completion));
    }

    public String solution(String[] participant, String[] completion) {
     /*   String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String s: participant) {
            map.put(s, map.getOrDefault(s,0)+1);
        }


        for (String s : completion){
            map.put(s, map.get(s)-1);
        }

        for (String key : map.keySet()) {
            if (map.get(key) !=0 ) {
              return key;
            }
        }
        System.out.println(map);
        return answer;*/

        Arrays.sort(participant);
        Arrays.sort(completion);
        int i = 0;
        for (; i< participant.length; i++){
            if (!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[i];
    }
}
