import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MatchTest {

    @Test
    void shouldInitializeMatchWithZeroScores() {
        Match match = new Match("Mexico", "Canada");

        assertEquals("Mexico", match.getHomeTeam());
        assertEquals("Canada", match.getAwayTeam());
        assertEquals(0, match.getHomeScore());
        assertEquals(0, match.getAwayScore());
    }

    @Test
    void shouldUpdateScores() {
        Match match = new Match("Mexico", "Canada");

        match.setHomeScore(3);
        match.setAwayScore(2);

        assertEquals(3, match.getHomeScore());
        assertEquals(2, match.getAwayScore());
    }

    @Test
    void shouldReturnTotalScore() {
        Match match = new Match("Spain", "Brazil");

        match.setHomeScore(10);
        match.setAwayScore(2);

        assertEquals(12, match.getTotalScore());
    }

    @Test
    void shouldFormatMatchAsStringCorrectly() {
        Match match = new Match("Germany", "France");
        match.setHomeScore(2);
        match.setAwayScore(2);

        assertEquals("Germany 2 - France 2", match.toString());
    }


    @Test
    void shouldNotAllowNegativeScores() {
        Match match = new Match("Germany", "France");
        assertThrows(IllegalArgumentException.class, () -> match.setHomeScore(-1));
        assertThrows(IllegalArgumentException.class, () -> match.setAwayScore(-1));
    }
}
