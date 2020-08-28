package net.velion.arena.mode;

import net.velion.Player;
import net.velion.arena.match.Match;
import net.velion.arena.scoring.Scoreboard;
import net.velion.arena.team.Team;
import net.velion.arena.team.TeamTickets;
import net.velion.controlling.SpawnPoint;
import net.velion.party.Party;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class ArenaMode {
    protected final List<SpawnPoint> spawnPoints;
    protected final Match match;
    protected final List<Team> teams;
    protected final Scoreboard scoreboard;

    public ArenaMode(Match match, List<SpawnPoint> spawnPoints, List<Team> teams) {
        this.match = match;
        this.spawnPoints = spawnPoints;
        this.teams = teams;
        scoreboard = new Scoreboard();
    }

    private List<Player> getAllPlayers() {
        return teams.stream().map(Team::getMembers).flatMap(List::stream).collect(Collectors.toList());
    }

    public int getPlayerCount() {
        return teams.stream().mapToInt(Team::count).sum();
    }

    protected List<SpawnPoint> getAvailableSpawnPoints(Player player) {
        return spawnPoints.stream().filter(spawnPoint -> {
            if (spawnPoint.ignoringTeams()) {
                return true;
            }
            return spawnPoint.containsTeam(player.getTeam());
        }).collect(Collectors.toList());
    }

    private List<Team> getSmallestTeams() {
        if (teams.isEmpty()) {
            return null;
        }

        int count = Collections.min(teams.stream().map(team -> {
            return team.count();
        }).collect(Collectors.toList()));

        return teams.stream().filter(team -> {
            return team.count() == count;
        }).collect(Collectors.toList());
    }

    public void join(Player player) {
        List<Team> teams = getSmallestTeams();
        Random random = new Random();
        teams.get(random.nextInt(teams.size())).join(player);
    }

    public void partyJoin(Party party) {
        List<Team> teams = getSmallestTeams();
        int teamIndex = new Random().nextInt(teams.size());
        for (Player player : party.getMembers()) {
            teams.get(teamIndex).join(player);
        }
    }

    public void respawnRandom(Player player) {
        List<SpawnPoint> spawnPoints = getAvailableSpawnPoints(player);
        if (!spawnPoints.isEmpty()) {
            Random random = new Random();
            TeamTickets tickets = player.getTeam().getTickets();
            if (tickets.useTicket()) {
                SpawnPoint spawnPoint = spawnPoints.get(random.nextInt(spawnPoints.size()));
                respawn(player, spawnPoint);
            }
        }
    }

    public void respawn(Player player, SpawnPoint spawnPoint) {
        if (getAvailableSpawnPoints(player).contains(spawnPoint)) {
            //TODO implement respawing
        }
    }

    public void start() {
        getAllPlayers().forEach(this::respawnRandom);
        match.start();
    }
}
