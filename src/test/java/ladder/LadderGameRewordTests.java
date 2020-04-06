package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 게임 보상 테스트")
public class LadderGameRewordTests {

    @DisplayName("사다리 게임 보상 테스트")
    @Test
    public void generateLadderHeightTests() {
        assertThatCode(() -> LadderGameReword.of("5000")).doesNotThrowAnyException();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGameReword.of(null))
                .withMessageContaining("LadderGameReword is empty");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGameReword.of(""))
                .withMessageContaining("LadderGameReword is empty");
    }

    @DisplayName("사다리 게임 보상 (복수) 테스트")
    @Test
    public void generateLadderHeightTests() {
        assertThatCode(() -> LadderGameRewords.newInstance("꽝,5000,꽝,3000")).doesNotThrowAnyException();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGameRewords.of(null))
                .withMessageContaining("LadderGameRewords is empty");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderGameReword.of(Collections.EMPTY_SET))
                .withMessageContaining("LadderGameRewords is empty");
    }
}
