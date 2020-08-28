package net.velion.arena.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Match {
    final List<Round> rounds;
    int currentRound;

    public Match() {
        rounds = new ArrayList<>();
        currentRound = -1;
    }

    public void addRound(Round round) {
        rounds.add(round);
        round.setMatch(this);
    }

    public MatchStatus checkForNextRound() {
        if (!rounds.get(currentRound).isOver()) {
            return MatchStatus.RUNNING;
        } else if (rounds.get(currentRound).isOver() && currentRound < rounds.size() - 1) {
            currentRound++;
            rounds.get(currentRound).start();
            return MatchStatus.RUNNING;
        } else {
            return MatchStatus.OVER;
        }
    }

    public void start() {
        currentRound = 0;
        rounds.get(currentRound).start();
    }
}
