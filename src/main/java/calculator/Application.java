package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //String input = null;
        //String input = "";
        //String input = "1:2,3";
        //String input = "//.\n1.2.3:4,5";

        int sum = 0;
        //빈 문자열이나 null을 입력받으면 0
        if(input == null || input.trim().equals("")) { //isEmpty()도 가능. trim 해주는 것도 일종의 예외 처리?.null부터 체크해줘야함!!
            sum =0;
        }
        String[] numbers;

        //커스텀 구분자가 있을 경우 커스텀 구분자 인식 후 추출
        if(input.startsWith("//")&& input.contains("\n")) {
            String custom = input.substring(2, input.indexOf("\n"));
            String customInput = input.substring(input.indexOf("\n")+1);
            //뒷부분만 split
            numbers = customInput.split("[:,]|"+ Pattern.quote(custom));
        }else{
            //기본 구분자(:,)로 문자열 분리
            numbers = input.split("[:,]");//정규식 표현
        }

        //합산
        for(String number : numbers) {
            sum+=Integer.parseInt(number); //문자열을 숫자로 바꾼 후 더함
        }


        //출력
        System.out.println(sum);

    }
}
