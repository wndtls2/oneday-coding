package M07.D07;

/*
 * int 형 숫자를 하나 입력받아 1인 비트 개수를 세는 매서드를 작성하세요.
 * 단 Integer.toBinaryString 또는 Interger.toString 함수를 사용하지 않고 구현합니다.
 *
 * Ex) 입력 7 -> 0111
 * 결과 : 3
 */
public class CountBits {
    public static void main(String[] args) {
        bits(16);
    }

    public static long bits(int number){
        long result = 0;
        String result2 = "";
        for(int i=number; i>0; i/=2) {
            result2 = String.valueOf(i%2) + result2;
        }

        result = Long.parseLong(result2);
        System.out.println(result);
        return result;
    }
}
