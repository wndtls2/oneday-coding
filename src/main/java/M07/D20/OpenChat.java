package M07.D20;

import java.util.*;

/*
* @url : https://programmers.co.kr/learn/courses/30/lessons/42888
*
* */
public class OpenChat {
    public static void main(String[] args) {
     OpenChat oc = new OpenChat();
     String[] arr = {"Enter uid1234 Muzi",
                     "Enter uid4567 Prodo",
                     "Leave uid1234",
                     "Enter uid1234 Prodo",
                     "Change uid4567 Ryan"};
        for (String v :oc.solution(arr)){
            System.out.println(v);
        }

    }

    public String[] solution(String[] record) {
        Map<String, String> codeMap = new HashMap<String, String>();
        codeMap.put("enter","들어왔습니다.");
        codeMap.put("leave","나갔습니다.");

        HashMap<String, String> uidMap = new HashMap<String, String>();
        List<String> list = new ArrayList<String>();

        for(String str:record){
            String[] split = str.split(" ");
            String code = split[0];
            String uid = split[1];

            //"Enter uid1234 Muzi"
            if(split.length > 2) {
                String name = split[2];
                uidMap.put(uid, name);
            }

            if(!"Change".equals(code)){
                list.add(code +" "+uid);
            }
        }
        System.out.println(list);
        System.out.println(uidMap);

        String[] answer = new String[list.size()];
        for(int i=0;i<answer.length;i++){
            String[] split = list.get(i).split(" ");
            String name = uidMap.get(split[1]);
            answer[i] = name+"님이 "+ codeMap.get(split[0].toLowerCase());
        }

        return answer;
    }
}
