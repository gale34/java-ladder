package ladder;

import ladder.model.LadderBridge;
import ladder.model.LadderLine;
import ladder.model.LadderLineOld;
import ladder.model.LadderPole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.model.LadderBridge.EXIST;
import static ladder.model.LadderBridge.UN_EXIST;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("사다리 라인(가로) 테스트")
public class LadderLineTests {

    @DisplayName("라인 생성 테스트")
    @Test
    public void generateLadderLineTests() {
        assertThatCode(() -> LadderLineOld.newInstance(7)).doesNotThrowAnyException();
    }

    @DisplayName("라인 생성 - 비정상 테스트")
    @Test
    public void generateLadderLineAbnormalTests() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLineOld.newInstance(-13))
                .withMessageContaining("Ladder Pole count must be greater than zero.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLineOld.newInstance(0))
                .withMessageContaining("Ladder Pole count must be greater than zero.");


        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderLineOld.newInstance(EXIST, EXIST, UN_EXIST))
                .withMessageContaining("Ladder Bridge can not set to consecutive.");
    }

    @DisplayName("라인 생성 - 사이즈 테스트")
    @Test
    public void compareLadderLineTests() {
        LadderLineOld ladderLine = LadderLineOld.newInstance(7);
        assertThat(ladderLine.poleCount()).isEqualTo(7);
    }

    @DisplayName("사다리 라인 움직임 테스트")
    @Test
    public void nextLadderPolesTests() {
        LadderLineOld ladderLine = LadderLineOld.newInstance(UN_EXIST, EXIST, UN_EXIST);

        assertThat(ladderLine.moveLadderPole(LadderPole.of(0))).isEqualTo(LadderPole.of(0));
        assertThat(ladderLine.moveLadderPole(LadderPole.of(1))).isEqualTo(LadderPole.of(2));
        assertThat(ladderLine.moveLadderPole(LadderPole.of(2))).isEqualTo(LadderPole.of(1));
        assertThat(ladderLine.moveLadderPole(LadderPole.of(3))).isEqualTo(LadderPole.of(3));
    }

    @DisplayName(" (가로 라인이 연속으로 나오지 않는지) 테스트")
    @Test
    public void generateLadderConsecutiveBridgeTests() {
        LadderLineOld ladderLine = LadderLineOld.newInstance(5);
        List<LadderBridge> bridges = ladderLine.getBridges();

        LadderBridge preLadderBridge = UN_EXIST;
        for (int i = 0; i < bridges.size(); i++) {
            assertTrue(validateConsecutiveBridge(preLadderBridge, bridges.get(i)));
            preLadderBridge = bridges.get(i);
        }
    }

    private static boolean validateConsecutiveBridge(LadderBridge preBridge, LadderBridge nowBridge) {
        return preBridge != nowBridge || nowBridge == UN_EXIST;
    }

    @Test
    public void init() {
        int sizeOfPerson = 5;
        System.out.println(LadderLine.init(sizeOfPerson));
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(LadderPole.of(0)));
    }
}
