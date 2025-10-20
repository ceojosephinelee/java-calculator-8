package calculator;

public class Application {
    public static void main(String[] args) {
        //입력
        String input = InputView.readInput();

        //빈 문자열이나 null을 입력받으면 0
        Validator.validateEmpty(input);//입력 안에 들어가야 하나?

        //문자열 분리
        String[] strs = StringSeparator.splitter(input);

        //분리된 문자열 예외 처리. 합산
        int sum = Adder.adder(strs);

        //출력
        OutputView.printer(sum);
    }
}
