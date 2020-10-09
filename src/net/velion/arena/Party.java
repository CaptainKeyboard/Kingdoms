package net.velion.arena;

import java.util.List;

public class Party {
    private List<Player> players;
    private Player leader;

    public Party(Player leader) {
        this.leader = leader;
    }

    public void join(Player player) {
        if (player.getParty() == null) {
            players.add(player);
            player.setParty(this);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
