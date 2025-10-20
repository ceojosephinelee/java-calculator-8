package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String readInput() {
        String input = Console.readLine();
        //테스트코드는 Console.readLine() 때문에  \\n으로 입력할테니 \n으로 replace 해주면 됨.
        input = input.replace("\\n", "\n");
        return input;
    }
}
