package net.velion.arena;

import net.velion.arena.round.Round;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    protected List<Player> players;
    private List<Round> rounds;
    private int currentRound;

    public Arena() {
        players = new ArrayList<>();
        rounds = new ArrayList<>();
        currentRound = 0;
    }

    public void start() {
        rounds.get(currentRound).start();
    }

    public void reset() {
        currentRound = 0;
        for (Round round : rounds) {
            round.reset();
        }
    }

    public void setRounds(List<Round> rounds) {
        this.rounds = rounds;
    }

    public void addRound(Round round) {
        rounds.add(round);
    }

    public void join(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<? extends IArenaEntity> getEntities() {
        return players;
    }
}
