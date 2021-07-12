package M07.D08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
* 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수,
* solution을 완성하세요.
* 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
*
* */
public class WordValidation {

    public static void main(String[] args) {
        WordValidation wv = new WordValidation();
        wv.solution("11231"+"d");
    }

    public boolean solution(String s) {
        int length = s.length();

        if (length > 0 && length <= 8){
            if (length == 4 || length == 6){
                List<String> list = Arrays.stream(s.split(""))
                        .collect(Collectors.toList());
                for (String v : list) {
                    System.out.print(v + "  : "+v.matches("[0-9]") + " | ");
                    if (!v.matches("[0-9]")) {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }
}
