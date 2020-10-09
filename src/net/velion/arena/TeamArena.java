package net.velion.arena;

import java.util.*;
import java.util.stream.Collectors;

public class TeamArena extends Arena {
    private List<Team> teams;

    public TeamArena() {
        teams = new ArrayList<>();
    }

    public void start() {
        assignTeams();
        super.start();
    }

    public void assignTeams() {
        List<Player> players = new ArrayList<>(this.players);
        Set<Party> parties = getAllParties();
        Random random = new Random();
        for (Party party : parties) {
            List<Team> teams = getSmallestTeams();
            Team team = teams.get(random.nextInt(teams.size()));
            List<Player> partyMembers = party.getPlayers();
            team.addAllMembers(partyMembers);
            players.removeAll(partyMembers);
        }
        for (Player player : players) {
            List<Team> teams = getSmallestTeams();
            Team team = teams.get(random.nextInt(teams.size()));
            team.addMember(player);
        }
    }

    private Set<Party> getAllParties() {
        Set<Party> parties = new HashSet<>();
        for (Player player : players) {
            if (player.getParty() != null) {
                parties.add(player.getParty());
            }
        }
        return parties;
    }

    private List<Team> getSmallestTeams() {
        if (teams.isEmpty()) {
            return null;
        }

        int count = Collections.min(teams.stream().map(Team::size).collect(Collectors.toList()));

        return teams.stream().filter(team -> {
            return team.size() == count;
        }).collect(Collectors.toList());
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public List<? extends IArenaEntity> getEntities() {
        return teams;
    }
}
