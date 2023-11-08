package study;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sskim
 */
public class ScoreCollection {

    List<Scoreable> scoreables = new ArrayList<>();

    //합계
    public void add(Scoreable scoreable) {
        this.scoreables.add(scoreable);
    }

    //평균 정적 메서드
    public int getAverage() {
        int total = scoreables.stream()
                .mapToInt(Scoreable::getScore)
                .sum();
        return Math.round(total / scoreables.size());
    }
}
