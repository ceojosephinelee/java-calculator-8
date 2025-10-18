package calculator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        try {
            input = br.readLine(); //주의!!!!!!!br.readLine()은 한 줄만 읽음! \n을 기준으로 substring 할 수 없음.
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int sum = 0;
        //빈 문자열이나 null을 입력받으면 0
        if(input == null || input.trim().equals("")) { //isEmpty()도 가능. trim 해주는 것도 일종의 예외 처리?.null부터 체크해줘야함!!
            sum =0;
        }
        String[] strs; //배열은 길이 고정인거 아닌가?

        if(input.startsWith("//")) { //커스텀 구분자는 다음 줄 입력 받아야함 커스텀 구분자 없다면 두번째 줄 있으면 예외 처리

            String custom = input.substring(2); //커스텀 구분자 추출
            //커스텀 구분자 예외 처리
            if(custom.isEmpty()||custom.contains(" ")) {
                throw new IllegalArgumentException("커스텀 구분자가 비어있습니다");
            }else if(custom.length()>1){
                throw new IllegalArgumentException("커스텀 구분자는 한 글자여야 합니다");
            }
            if (!custom.matches("[^0-9]")) {//이건 문제 조건에 없지만 내가 추가함
                throw new IllegalArgumentException("커스텀 구분자는 숫자일 수 없습니다.");
            }
            //첫번째 줄 커스텀 구분자 정상 입력받으면 두 번째 줄 입력받기
            String input2;//2번째 줄 입력받기
            try {
                input2=br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            // 세 번째 줄이 존재하는지 확인 (있으면 예외 처리)
            try {
                if (br.ready()) { // 다음 입력 줄이 남아 있다면
                    throw new IllegalArgumentException("커스텀 구분자 사용 시 문자열은 두 줄까지만 입력 가능합니다.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            strs = input2.split("[:,]|"+ Pattern.quote(custom)); //기본구분자 & 커스텀 구분자로 분리
        }else{
            //기본 구분자만 사용 시 문자열 한 줄까지만 입력 가능
            try {
                if (br.ready()) { // 다음 입력 줄이 남아 있다면
                    throw new IllegalArgumentException("기본 구분자 사용 시 문자열은 한 줄까지만 입력 가능합니다.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
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
                sum+=num; //입력 정상이면 합산
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("정수가 아닙니다");
            }
        }
        //출력
        System.out.println("결과 : "+sum);
    }
}
