import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/* 다음 array는 물건의 중량이다. Array의 순서대로 물건을 상자에 담되,
* 중량이 20을 넘지 않도록 상자를 분할하는 출력 함수를 만드시오.
* 예) 9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2
*
* 결과 )
* 9 7
* 6 6 4 3
* 4 5 3 4 3
* 4 1 2
 */
public class StackQuestion {
    public static void main(String[] args) {
        List<Stack<Integer>> stackList = doDo();
        for (Stack<Integer> stack : stackList) {
            for (Integer element : stack) {
                System.out.print(element.toString() + " ");
            }
            System.out.println();
        }
    }
    public static List<Stack<Integer>> doDo() {
        final List<Integer> elements = Arrays.asList(9, 7, 6, 6, 4, 3, 4, 5, 3, 4, 3, 4, 1, 2);
        List<Stack<Integer>> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer i: elements) {
            int sum = stack.stream()
                    .mapToInt(s->s)
                    .sum()+i;

            if (sum > 20) {
                Stack<Integer> el = new Stack<Integer>();
                while (!stack.empty()){
                    el.push(stack.pop());
                }
                result.add(el);
            }
            stack.push(i);

        }
        result.add(stack);
        return result;
    }
}
