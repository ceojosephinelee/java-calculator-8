package calculator;

import java.util.regex.Pattern;

public class StringSeparator {
    public static String[] splitter(String input) {
        String[] strs;
        if(input.startsWith("//")) {
            int newLineIndex = input.indexOf("\n"); //indexOf에 첫번째로 나오는 것이라는 의미가 내포되어 있음!따라서 뒤에 \\n 또 나와도 상관x->후에 커스텀과 기본 구분자 외의 문자로 예외 처리될 것임
            Validator.validateNewLine(newLineIndex); //  \n 이 없는 경우 예외 처리
            String customSeparator = input.substring(2,newLineIndex); //커스텀 구분자 추출
            Validator.validateSplitter(customSeparator); //커스텀 구분자 예외 처리
            String sentence = input.substring(newLineIndex+1); //"\n"는 하나의 인덱스로 인식!, 4라고 적어도 되지만 가독성.유지보수성 떨어짐.
            strs = sentence.split("[:,]|"+ Pattern.quote(customSeparator)); //기본구분자 & 커스텀 구분자로 분리
            return strs;
        }
        //else 쓰지 않도록 리팩토링
        //기본 구분자(:,)로 문자열 분리
        strs = input.split("[:,]");//정규식 표현
        return strs;
    }
}
