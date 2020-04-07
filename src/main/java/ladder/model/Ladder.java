package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<LadderLine> lines;

    private Ladder(final List<LadderLine> lines) {
        validate(lines);
        this.lines = Collections.unmodifiableList(lines);
    }

    private void validate(final List<LadderLine> lines) {
        if (Objects.isNull(lines) || lines.isEmpty()) {
            throw new IllegalArgumentException("Ladder Lines must be existed.");
        }
    }

    public static Ladder newInstance(final int poleCount, final int height) {
        List<LadderLine> ladders = IntStream.range(0, height)
                .mapToObj(i -> LadderLine.newInstance(poleCount))
                .collect(Collectors.toList());
        return new Ladder(ladders);
    }

    public static Ladder newInstance(final List<LadderLine> ladderLines) {
        return new Ladder(ladderLines);
    }

    public LadderPoles proceedAll() {
        LadderPoles ladderPoles = getInitLadderPoles();

        for (LadderLine ladderLine : lines) {
            ladderPoles = ladderLine.proceed(ladderPoles);
        }

        return ladderPoles;
    }

    private LadderPoles getInitLadderPoles() {
        return lines.stream()
                .findAny()
                .map(LadderLine::getInitLadderPoles)
                .orElseThrow(() -> new IllegalArgumentException("Can not find ladder line."));
    }

    public List<LadderLine> getLines() {
        return lines;
    }
}
