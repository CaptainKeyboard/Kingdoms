package net.velion.arena;

import net.velion.arena.capturing.CapturePoint;
import net.velion.arena.round.Round;
import net.velion.arena.validation.ArenaInvalidException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Arena {
    protected final String name;
    protected final List<Player> players;
    private final List<IArenaEntity> winner;
    private List<Round> rounds;
    private int currentRound;
    private Status status = Status.NOT_STARTED;

    // TODO replace!
    private int time = 0;

    public Arena(String name) {
        this.name = name;
        players = new ArrayList<>();
        rounds = new ArrayList<>();
        currentRound = -1;
        winner = new ArrayList<>();
    }

    public void start() throws ArenaInvalidException {
        validate();
        System.out.println("Arena: " + name + " starting");
        status = Status.RUNNING;
        nextRound();
    }

    public void reset() {
        currentRound = -1;
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

    public void check() {
        if (getCurrentRound().check() == Status.OVER) {
            IArenaEntity roundWinner = getCurrentRound().getWinner();
            winner.add(roundWinner);
            if (hasNextRound()) {
                nextRound();
            } else {
                status = Status.OVER;
                getWinner();
            }
        }
    }

    private void update(IArenaEntity entity) {
        getCurrentRound().update(entity);
    }

    private void getWinner() {
        Map<IArenaEntity, Long> frequency = this.winner.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Long max = Collections.max(frequency.values());
        List<IArenaEntity> winnerMap = frequency.entrySet().stream().filter(entry -> entry.getValue().equals(max)).map(Map.Entry::getKey).collect(Collectors.toList());
        List<String> test = winnerMap.stream().map(IArenaEntity::getName).collect(Collectors.toList());
        System.out.println("Winner: " + test);
    }

    private void nextRound() {
        currentRound++;
        getCurrentRound().start();
    }

    private boolean hasNextRound() {
        return currentRound + 1 < rounds.size();
    }

    public Round getCurrentRound() {
        return rounds.get(currentRound);
    }

    public Status getStatus() {
        return status;
    }

    private void validate() throws ArenaInvalidException {
        if (rounds.isEmpty()) {
            throw new ArenaInvalidException(1);
        } else {
            for (Round round : rounds) {
                round.validate();
            }
        }
    }

    // TODO Following methods are only for testing purpose. They have to be replaced
    public void kill(Player player1) {
        if (status == Status.RUNNING) {
            player1.getScore().addKill(100);
            if (this instanceof TeamArena) {
                update(player1.getTeam());
            } else {
                update(player1);
            }
        }
    }

    public void capture(CapturePoint capturePoint1, Player player) {
        if (status == Status.RUNNING) {
            if (this instanceof TeamArena) {
                capturePoint1.capture(player.getTeam());
                update(player.getTeam());
            } else {
                capturePoint1.capture(player);
                update(player);
            }
        }
    }

    public int getCurrentTime() {
        return time;
    }

    public void setTime(int time) {
        if (status == Status.RUNNING) {
            this.time = time;
            update(null);
        }
    }
}
