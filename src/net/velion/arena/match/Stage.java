package net.velion.arena.match;

import net.velion.arena.objectives.Objective;
import net.velion.arena.team.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Stage {
    final List<Objective> objectives = new ArrayList<>();
    Round round;

    public Stage() {
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public void addObjective(Team team, Objective objective) {
        objectives.add(objective);
    }

    public List<Objective> getTeamObjectives(Team team) {
        return objectives.stream().filter(objective -> {
            return objective.getTeam().equals(team);
        }).collect(Collectors.toList());
    }

    public void check(Team team) {
        boolean status = true;
        for (Objective objective : getTeamObjectives(team)) {
            if (!objective.isReached()) {
                status = false;
            }
        }

        // TODO Delete! Only for testing!
        if (status) System.out.println(team.getName() + " has won!");
    }
}
