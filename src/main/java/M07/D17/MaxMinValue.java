package M07.D17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
/*
* 문자열 s에는 공백으로 구분된 숫자들이 저장되어 있습니다.
* str에 나타나는 숫자 중 최소값과 최대값을 찾아 이를 "(최소값) (최대값)"형태의 문자열을 반환하는 함수, solution을 완성하세요.
* 예를들어 s가 "1 2 3 4"라면 "1 4"를 리턴하고, "-1 -2 -3 -4"라면 "-4 -1"을 리턴하면 됩니다.
*
* 제한 조건
* s에는 둘 이상의 정수가 공백으로 구분되어 있습니다.
* */
public class MaxMinValue {
    public String solution(String s) {
        String answer = "";
        String[] array = s.split(" ");
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String v: array) {
           list.add(Integer.parseInt(v));
        }
        int max = list.stream()
                .sorted()
                .collect(Collectors.toList()).get(list.size()-1);
        int min = list.stream()
                .sorted()
                .collect(Collectors.toList()).get(0);

        answer = sb.append(Integer.toString(min)+" " + Integer.toString(max)).toString();
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) {
        MaxMinValue mmv = new MaxMinValue();
        mmv.solution("1 23 3 4");
    }
}
