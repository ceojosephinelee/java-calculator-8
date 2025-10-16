package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
//br 쓰면 try-catch 선언해줘야함? 그냥 scanner 로 할까?
public class Application {
    public static void main(String[] args) {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        try {  //여기서 갑자기 왜 try-catch?
            input = br.readLine(); //주의!!!!!!!br.readLine()은 한 줄만 읽음! \n을 기준으로 substring 할 수 없음.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //String input = null;
        //String input = "";
        //String input = "1:2,3";
        int sum = 0;
        //빈 문자열이나 null을 입력받으면 0
        if(input == null || input.trim().equals("")) { //isEmpty()도 가능. trim 해주는 것도 일종의 예외 처리?.null부터 체크해줘야함!!
            sum =0;
        }
        String[] numbers;
        //커스텀 구분자가 있을 경우 커스텀 구분자 인식 후 추출
        String input2;//2번째 줄 입력받기
        try {
            input2=br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if(input.startsWith("//")&& input2 !=null) { //커스텀 구분자는 다음 줄 입력 받아야함
            String custom = input.substring(2); //커스텀 구분자 추출
            //다음줄 입력받아서 분리
            numbers = input2.split("[:,]|"+ Pattern.quote(custom)); //기본구분자 & 커스텀 구분자로 분리
        }else{
            //기본 구분자(:,)로 문자열 분리
            numbers = input.split("[:,]");//정규식 표현
        }
        //합산
        for(String number : numbers) {
            sum += Integer.parseInt(number); //문자열을 숫자로 바꾼 후 더함
        }
        //출력
        System.out.println("결과 : "+sum);
    }
}
