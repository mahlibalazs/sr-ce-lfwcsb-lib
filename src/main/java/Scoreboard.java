import java.util.HashMap;
import java.util.Map;

public class Scoreboard {

    private final Map<String, Match> matches = new HashMap<>();

    private String key(String homeTeam, String awayTeam) {
        return homeTeam + "-" + awayTeam;
    }

    public void startMatch(String homeTeam, String awayTeam) {
        // TODO
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        // TODO
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        // TODO
    }

    public void summary() {
        // TODO
    }

}
