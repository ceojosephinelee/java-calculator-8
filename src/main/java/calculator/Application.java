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

        int answer = 0;
        //빈 문자열이나 null을 입력받으면 답은 0
        if(input == null || input.trim().equals("")) { //isEmpty()도 가능. trim 해주는 것도 일종의 예외 처리?.null부터 체크해줘야함!!
            answer =0;

        }
        //출력
        System.out.println(answer);

    }
}
