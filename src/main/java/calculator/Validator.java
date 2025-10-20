package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Validator {
    public static void validateEmpty(String input) { //뭘 반환하는 거지?
        if(input == null || input.trim().equals("")) { //isEmpty()도 가능. trim 해주는 것도 일종의 예외 처리?.null부터 체크해줘야함!!
            int result =0;
            OutputView.printer(result);
            Console.close();
            return;
        }

    }
    public static void validateNewLine(int newLineIndex) {  //  \n 이 없는 경우 예외 처리

        if(newLineIndex == -1) { //찾는 문자가 없을 때 -1
            throw new IllegalArgumentException("커스텀 구분자 사용시 줄바꿈이 필요합니다");
        }
    }
    public static void validateSplitter(String customSeparator) {  //커스텀 구분자 예외 처리

        if(customSeparator.isEmpty()) {
            throw new IllegalArgumentException("커스텀 구분자가 비어있습니다");
        }else if(customSeparator.length()>1){
            throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다");
        }
        if (!customSeparator.matches("[^0-9]")) { //문제 조건에 없지만 내가 추가함
            throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
        }
    }
    public static void validateNumber(String str) {
        if(str.isEmpty()) { //""
            throw new IllegalArgumentException("빈 문자열이 있습니다.");
        }else if(str.contains(" ")){ //"2 "
            throw new IllegalArgumentException("입력에 공백이 포함되어 있습니다.");
        }
        try{
            int num= Integer.parseInt(str);
            if(num<=0){
                throw new IllegalArgumentException("양수를 입력해야합니다");
            }

        }catch (NumberFormatException e){
            throw new IllegalArgumentException("정수가 아닙니다");
        }
    }
}
