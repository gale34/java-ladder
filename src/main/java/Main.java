import ladder.model.*;
import ladder.model.dto.LadderGameConsoleResult;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Main {
    public static void main(String[] args) {
        Members members = Members.newInstance(InputView.inputMembers());

        LadderHeight ladderHeight = LadderHeight.newInstance(InputView.inputLadderHeight());

        // TODO: 2020-04-07 inputview 실행결과 추가
        Ladder ladder = Ladder.newInstance(members.count(), ladderHeight, LadderGameRewords.newInstance("test"));

        LadderGame ladderGame = LadderGame.newInstance(members, ladder);

        OutputView.printResult(LadderGameConsoleResult.newInstance(ladderGame));
    }
}
