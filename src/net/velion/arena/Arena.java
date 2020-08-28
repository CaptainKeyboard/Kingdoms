package net.velion.arena;

import net.velion.Player;
import net.velion.arena.mode.ArenaMode;
import net.velion.arena.team.Team;
import net.velion.party.Party;

public class Arena {
    private ArenaMode arenaMode;
    private final boolean canJoinRunning;
    private final int minimalPlayers;
    private final int maximalPlayers;
    private int currentPlayers;
    private boolean isRunning;

    public Arena(boolean canJoinRunning, int minimalPlayers, int maximalPlayers) {
        this.canJoinRunning = canJoinRunning;
        this.minimalPlayers = minimalPlayers;
        this.maximalPlayers = maximalPlayers;
        isRunning = false;
    }

    public void setArenaMode(ArenaMode arenaMode) {
        this.arenaMode = arenaMode;
    }

    public void join(Player player) {
        if(!isRunning || canJoinRunning) {
            if (currentPlayers < maximalPlayers) {
                arenaMode.join(player);
            }
        }
    }

    public void partyJoin(Party party) {
        if (currentPlayers + party.size() <= maximalPlayers) {
            arenaMode.partyJoin(party);
        }
    }

    public boolean switchTeam(Team team, Player player) {
        if ((float) team.count() / player.getTeam().count() > 1.2) {
            team.join(player);
            return true;
        }
        return false;
    }

    public void tryStart() {
        if (minimalPlayers <= arenaMode.getPlayerCount()) {
            isRunning = true;

            // TODO start arena
        }
    }

    public void start() {
        arenaMode.start();
    }
}
