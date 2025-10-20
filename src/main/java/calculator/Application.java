package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        //입력
        String input = Console.readLine();
        //테스트코드는 Console.readLine() 때문에  \\n으로 입력할테니 \n으로 replace 해주면 됨.
        input = input.replace("\\n", "\n");
        //빈 문자열이나 null을 입력받으면 0
        if(input == null || input.trim().equals("")) { //isEmpty()도 가능. trim 해주는 것도 일종의 예외 처리?.null부터 체크해줘야함!!
            System.out.println("결과 : 0");
            Console.close();
            return;
        }
        String[] strs;
        int sum = 0;
        if(input.startsWith("//")) {
            int newLineIndex = input.indexOf("\n"); //indexOf에 첫번째로 나오는 것이라는 의미가 내포되어 있음!따라서 뒤에 \\n 또 나와도 상관x->후에 커스텀과 기본 구분자 외의 문자로 예외 처리될 것임
            //  \n 이 없는 경우 예외 처리
            if(newLineIndex == -1) { //찾는 문자가 없을 때 -1
                throw new IllegalArgumentException("커스텀 구분자 사용시 줄바꿈이 필요합니다");
            }
            String customSeperator = input.substring(2,newLineIndex); //커스텀 구분자 추출
            //커스텀 구분자 예외 처리
            if(customSeperator.isEmpty()) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다");
            }else if(customSeperator.length()>1){
                throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다");
            }
            if (!customSeperator.matches("[^0-9]")) { //문제 조건에 없지만 내가 추가함
                throw new IllegalArgumentException("숫자는 커스텀 구분자가 될 수 없습니다.");
            }
            String sentence = input.substring(newLineIndex+1); //"\n"는 하나의 인덱스로 인식!, 4라고 적어도 되지만 가독성.유지보수성 떨어짐.
            strs = sentence.split("[:,]|"+ Pattern.quote(customSeperator)); //기본구분자 & 커스텀 구분자로 분리
        }else{
            //기본 구분자(:,)로 문자열 분리
            strs = input.split("[:,]");//정규식 표현
        }
        //분리된 문자열 예외 처리
        for (String str : strs) {
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
                sum+=num; //입력이 정수이면서 양수이면 합산
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("정수가 아닙니다");
            }
        }
        //출력
        System.out.println("결과 : "+sum);
        Console.close();
    }
}
