package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author sskim
 */
class ScoreCollectionTest {

    @Test
    void 테스트() throws Exception{

        ScoreCollection scoreCollection = new ScoreCollection();

        scoreCollection.add(() -> 5);
        scoreCollection.add(() -> 7);

        int averageScore = scoreCollection.getAverage();

        assertThat(averageScore).isEqualTo(6);
    }
}