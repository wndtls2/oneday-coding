package M07.D16;
/*문제 설명
* 단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.
*
* 재한사항
* s는 길이가 1 이상, 100이하인 스트링입니다.
* */
public class CenterWord {

    public static void main(String[] args) {
        String v = new WordChange("agTga")
                .center()
                .getResult();

        System.out.println(v);
    }


    private static class WordChange{
        private String s;

        public WordChange(String s) {
            this.s = s;
        }

        public WordChange center(){
            int v = s.length();
            if ( v%2 == 1) {
                s =  Character.toString(s.charAt(v/2));
            } else {
                s =  s.substring(v/2-1, v/2+1);
            }
            return this;
        }
        private String getResult() {
            return s;
        }
    }
}
