import java.util.stream.Stream;

/*
 * 11968442L (Long)을
 * 98644211 로 변환해라
 */
public class LongChange {
    public static void main(String[] args) {
        System.out.println(solution(16339018));
    }
    public static void bubbleSort(long[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0 ; j < arr.length - i - 1 ; j++) {
                if(arr[j] < arr[j+1]) {
                    long temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }



    public static long solution(long n) {

        String value = String.valueOf(n);
        long[] digits = Stream.of(value.split(""))
                .mapToLong(s-> Long.parseLong(s)).toArray();

        bubbleSort(digits);

        StringBuilder sb = new StringBuilder();
        for (long i: digits) {
            sb.append(i);
        }
        return Long.parseLong(sb.toString());
    }
}
