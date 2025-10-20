package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1:3,2");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 커스텀_구분자_사용2() {
        assertSimpleTest(() -> {
            run("// \\n1 2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }
    @Test
    void 커스텀_구분자_사용3() {
        assertSimpleTest(() -> {
            run("//;\\n1;3,1");
            assertThat(output()).contains("결과 : 5");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_추가1(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("1;2,3"))
                .isInstanceOf(IllegalArgumentException.class)

        );
    }
    @Test
    void 예외_테스트_추가2(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//\n1,2,3"))
                    .isInstanceOf(IllegalArgumentException.class)

        );
    }
    @Test
    void 예외_테스트_추가3(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//; \n1;2,3"))
                    .isInstanceOf(IllegalArgumentException.class)

        );
    }
    @Test
    void 예외_테스트_추가4(){
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//3\n1,233"))
                    .isInstanceOf(IllegalArgumentException.class)

        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
