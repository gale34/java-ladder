package ladder.model.dto;

import ladder.model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LadderConsoleResult {

    private final List<Member> members;
    private final List<LadderLine> ladderLines;

    //Q1. unmodifiableList를 생성자에서 아예 쓰고 getter에서는 deepcopy만..?
    private LadderConsoleResult(final List<Member> members, final List<LadderLine> ladderLines) {
        this.members = Collections.unmodifiableList(members);
        this.ladderLines = Collections.unmodifiableList(ladderLines);
    }

    public static LadderConsoleResult newInstance(final LadderGame ladderGame) {
        return newInstance(ladderGame.getMembers(), ladderGame.getLadder());
    }

    public static LadderConsoleResult newInstance(final Members members, final Ladder ladder) {
        return new LadderConsoleResult(members.getMembers(), ladder.getLines());
    }

    public List<Member> getMembers() {
        return new ArrayList<>(members);
    }

    public List<LadderLine> getLadderLines() {
        return new ArrayList<>(ladderLines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LadderConsoleResult)) return false;
        LadderConsoleResult result = (LadderConsoleResult) o;
        return Objects.equals(getMembers(), result.getMembers()) &&
                Objects.equals(getLadderLines(), result.getLadderLines());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMembers(), getLadderLines());
    }
}
