package net.velion.arena.team;

import net.velion.Player;
import net.velion.arena.objectives.Objective;
import net.velion.arena.scoring.TeamScoreboard;

import java.util.ArrayList;
import java.util.List;

public class Team {
    final String name;
    final List<Player> members;
    final TeamTickets tickets;
    List<? extends Objective> objectives;
    final TeamScoreboard teamScoreboard;

    public Team(String name, int tickets) {
        this.name = name;
        this.members = new ArrayList<>();
        this.tickets = new TeamTickets(tickets);
        this.teamScoreboard = new TeamScoreboard(this);
    }

    public void join(Player player) {
        members.add(player);
        player.setTeam(this);
        teamScoreboard.addEntry(player);
    }

    public void leave(Player player) {
        members.remove(player);
    }

    public int count() {
        return members.size();
    }

    public List<Player> getMembers() {
        return members;
    }

    public TeamTickets getTickets() {
        return tickets;
    }

    public void setObjectives(List<? extends Objective> objectives) {
        this.objectives = objectives;
    }

    public String getName() {
        return name;
    }

    public TeamScoreboard getTeamScoreboard() {
        return teamScoreboard;
    }
}
