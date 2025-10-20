package calculator;

public class Adder {
    public static int adder(String[] strs) {
        int sum = 0;
        for (String str : strs) {
            Validator.validateNumber(str);
            sum+=Integer.parseInt(str); //입력이 정수이면서 양수이면 합산
        }
        return sum;

    }
}
