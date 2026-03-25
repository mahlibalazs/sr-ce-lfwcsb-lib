import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scoreboard {

    private final Map<String, Match> matches = new HashMap<>();

    private String key(String homeTeam, String awayTeam) {
        return homeTeam + "-" + awayTeam;
    }

    public void startMatch(String homeTeam, String awayTeam) {
        matches.put(key(homeTeam, awayTeam), new Match(homeTeam, awayTeam));
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Match match = matches.get(key(homeTeam, awayTeam));
        if (match == null) {
            throw new IllegalArgumentException("Match not found");
        }
        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
    }

    public void finishMatch(String homeTeam, String awayTeam) {
        matches.remove(key(homeTeam, awayTeam));
    }

    public String summary() {
        List<Match> list = new ArrayList<>(matches.values());

        Collections.reverse(list);

        list.sort(Comparator.comparingInt(Match::getTotalScore).reversed());

        StringBuilder sb = new StringBuilder();
        list.forEach(match -> sb.append(match).append("\n"));
        return sb.toString();
    }

}
