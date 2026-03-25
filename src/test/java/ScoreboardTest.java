import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoreboardTest {
    @Test
    void shouldStartMatchWithInitialScoreZero() {
        Scoreboard sb = new Scoreboard();
        sb.startMatch("Mexico", "Canada");

        String summary = sb.summary();

        assertTrue(summary.contains("Mexico 0 - Canada 0"));
    }

    @Test
    void shouldUpdateScoreCorrectly() {
        Scoreboard sb = new Scoreboard();
        sb.startMatch("Mexico", "Canada");

        sb.updateScore("Mexico", "Canada", 0, 5);

        String summary = sb.summary();

        assertTrue(summary.contains("Mexico 0 - Canada 5"));
    }

    @Test
    void shouldRemoveMatchWhenFinished() {
        Scoreboard sb = new Scoreboard();
        sb.startMatch("Mexico", "Canada");

        sb.finishMatch("Mexico", "Canada");

        assertEquals("", sb.summary().trim());
    }

    @Test
    void shouldSortSummaryByTotalScoreDescending() {
        Scoreboard sb = new Scoreboard();

        sb.startMatch("Mexico", "Canada");
        sb.updateScore("Mexico", "Canada", 0, 5);

        sb.startMatch("Spain", "Brazil");
        sb.updateScore("Spain", "Brazil", 10, 2);

        sb.startMatch("Germany", "France");
        sb.updateScore("Germany", "France", 2, 2);

        sb.startMatch("Uruguay", "Italy");
        sb.updateScore("Uruguay", "Italy", 6, 6);

        sb.startMatch("Argentina", "Australia");
        sb.updateScore("Argentina", "Australia", 3, 1);

        String summary = sb.summary();

        String[] lines = summary.split("\n");

        assertTrue(lines[0].contains("Uruguay 6 - Italy 6"));
        assertTrue(lines[1].contains("Spain 10 - Brazil 2"));
        assertTrue(lines[2].contains("Mexico 0 - Canada 5"));
        assertTrue(lines[3].contains("Argentina 3 - Australia 1"));
        assertTrue(lines[4].contains("Germany 2 - France 2"));

    }

    @Test
    void shouldThrowWhenUpdatingNonExistingMatch() {
        Scoreboard sb = new Scoreboard();

        assertThrows(IllegalArgumentException.class, () ->
                sb.updateScore("A", "B", 1, 1)
        );
    }

}
