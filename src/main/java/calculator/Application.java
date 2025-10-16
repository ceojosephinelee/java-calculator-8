package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        //String input = null;
        //String input = "";
        //String input = "1:2,3";

        int sum = 0;
        //빈 문자열이나 null을 입력받으면 0
        if(input == null || input.trim().equals("")) { //isEmpty()도 가능. trim 해주는 것도 일종의 예외 처리?.null부터 체크해줘야함!!
            sum =0;
        }
        //기본 구분자(:,)로 문자열 분리
        String[] numbers = input.split("[:,]");//정규식 표현
        //합산
        for(String number : numbers) {
            sum+=Integer.parseInt(number); //문자열을 숫자로 바꾼 후 더함
        }
        //출력
        System.out.println(sum);

    }
}
