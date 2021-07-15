package M07.D15;

import java.util.*;
import java.util.stream.Collectors;

/*
* 2021 KAKAO BLIND RECRUITMENT
* 신규 아이디 추천
* 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
* 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
* 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
* 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
* 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
* 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
*       (3단계) 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
* 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
* */
public class NewIdRecommend {

    public static void main(String[] args) {
        NewIdRecommend nid = new NewIdRecommend();
        nid.solution(".a6b1.");
        //aaa("qqaaba..bcccccbcc..");
    }
//6,18,26
    public String solution(String new_id) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        if (new_id.length() <= 1000 && new_id.length() > 0 ) {
            //1단계
            sb.append(new_id.toLowerCase());
            System.out.println("1 단계 : "+ sb.toString());

            //2단계
            String[] array = sb.toString().split("");
            for (String s: array) {
                //숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든문자 제거
                if (s.matches("[-_.a-z0-9]") ){
                    answer += s;
                }
            }
            System.out.println("2 단계 : "+ answer);
            //3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
            answer = answer.replaceAll("[.]{2,}",".");
            System.out.println("3 단계 : " + answer);


            ///4단계 마침표(.)가 처음이나 끝에 위치한다면 제거
            if (answer.startsWith(".")) {
                answer = answer.replaceFirst(".","");
            }
            if (answer.endsWith(".")) {
                answer = answer.replaceFirst(".$","");
            }
            System.out.println("4 단계 : " + answer);

            //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
            if ("".equals(answer)) {
                answer += "a";
            }
            System.out.println("5 단계 : " + answer);

            //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
            // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
            if (answer.length() >= 16 ) {
                answer = answer.substring(0, 15);
                if (answer.endsWith(".")) {
                    answer = answer.replaceFirst(".$","");
                }
            }
            System.out.println("6 단계 : " + answer);


            //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

            if (answer.length() <= 2 && answer.length() > 0) {
                while (answer.length() <= 2 ) {
                    if (answer.length() ==1) {
                        answer += answer.substring(0,1);
                    } else {
                        answer += answer.substring(1,2);
                    }
                }
                System.out.println("7 단계 : " + answer);
            }

        }
        return answer;
    }
}
