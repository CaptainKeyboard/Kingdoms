package net.velion.arena;

import net.velion.arena.round.Round;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Franz Kohout
 */
public class Arena {
    protected List<ArenaPlayer> players;
    protected List<? extends IArenaEntity> entities;
    private List<Round> rounds;
    private int currentRound;

    public Arena() {
        players = new ArrayList<>();
        entities = (List<? extends IArenaEntity>) players;
        rounds = new ArrayList<>();
        currentRound = 0;
    }

    public void start() {
        rounds.get(currentRound).start();
    }

    public void reset() {
        currentRound = 0;
        for(Round round: rounds) {
            round.reset();
        }
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public void addRound(Round round) {
        rounds.add(round);
    }
}
