package M07.D16;

import java.util.Arrays;

/*주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
* 숫자들이 들어있는 배열 nums가 매개변수로 주어질 때,
* nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
*
* 제한사항
* nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
* nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
*
* 입출력 예
*   nums	        result
* [1,2,3,4]	            1
* [1,2,7,6,4]	        4
* */
public class DecimalFind {
    public static void main(String[] args) {
        DecimalFind df = new DecimalFind();
        int[] iArray = {1,2,7,6,4,5,8,-1};

        df.solution(iArray);

    }


    public int solution(int[] nums) {
        int count =0;
        int result = 0;
        Arrays.sort(nums);

        DecimalUtil duChk = new DecimalUtil(nums);
        if (nums.length >=3 && nums.length <= 50
                && duChk.validationNum().isResult() && duChk.validationDistinct().isResult()) {
            for (int x = 0; x < nums.length - 2; x++) {
                for (int y = x + 1; y < nums.length - 1; y++) {
                    for (int z = y + 1; z < nums.length; z++) {
                        result = (nums[x] + nums[y] + nums[z]);
                        boolean du = new DecimalUtil()
                                .decimalCheck(result);
                        if (du) {
                            System.out.println(nums[x] + "," + nums[y] + "," + "" + nums[z] + "=" + result);
                            count++;
                        }

                    }
                }
            }
        } else {
            count = -1;
            String resultMessage = duChk.validationNum()
                            .validationDistinct()
                            .getErrType();
            System.out.println(resultMessage);
        }
        System.out.println(count);
        return count;
    }

    public static class DecimalUtil {
        private int[] validationValue;
        private boolean result;
        private final String[] ERR_MESSAGE = {"0 보다 작습니다.", "1000 초과입니다.", "중복되었습니다."};
        private String errType;

        public DecimalUtil(int[] v) {
            this.validationValue = v;
        }

        public DecimalUtil(){}

        public Boolean decimalCheck(int v) {
            for (int i=2; i*i <= v ; i++){
                if (v%i == 0) {
                    return false;
                }
            }
            return true;
        }

        public DecimalUtil validationNum() {

            for (int i: validationValue) {
                if (i <= 0) {
                    this.result = false;
                    this.errType = this.ERR_MESSAGE[0];
                    return this;
                }else
                if (i > 1000) {
                    this.result = false;
                    this.errType = this.ERR_MESSAGE[1];
                    return this;
                }
            }

            this.result= true;
            return this;
        }

        public DecimalUtil validationDistinct(){

            if (Arrays.stream(validationValue).distinct().count() != validationValue.length) {
                this.result = false;
                this.errType = this.ERR_MESSAGE[2];
                return this;
            }

            this.result = true;
            return this;
        }

        public boolean isResult() {
            return result;
        }

        public String getErrType(){
            return errType;
        }

    }

}
