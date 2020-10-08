package net.velion.arena;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Franz Kohout
 */
public class TeamArena extends Arena {
    private List<Team> teams;

    public TeamArena() {
        teams = new ArrayList<>();
        entities = (List<? extends IArenaEntity>) teams;
    }

    public void start() {
        assignTeams();
        super.start();
    }

    public void assignTeams() {
        List<ArenaPlayer> players = new ArrayList<>(this.players);
        Set<Party> parties = getAllParties();
        Random random = new Random();
        for(Party party: parties) {
            List<Team> teams = getSmallestTeams();
            Team team = teams.get(random.nextInt(teams.size()));
            List<ArenaPlayer> partyMembers = party.getPlayers();
            team.addAllMembers(partyMembers);
            players.removeAll(partyMembers);
        }
        for(ArenaPlayer player: players) {
            List<Team> teams = getSmallestTeams();
            Team team = teams.get(random.nextInt(teams.size()));
            team.addMember(player);
        }
    }

    private Set<Party> getAllParties() {
        Set<Party> parties = new HashSet<>();
        for(ArenaPlayer player: players) {
            parties.add(player.getParty());
        }
        return parties;
    }

    private List<Team> getSmallestTeams() {
        if (teams.isEmpty()) {
            return null;
        }

        int count = Collections.min(teams.stream().map(Team::getCount).collect(Collectors.toList()));

        return teams.stream().filter(team -> {
            return team.getCount() == count;
        }).collect(Collectors.toList());
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }
}
