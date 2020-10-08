package net.velion.arena;

import java.util.List;

/**
 * @author Franz Kohout
 */
public class Party {
    private List<ArenaPlayer> players;
    private ArenaPlayer leader;

    public Party(ArenaPlayer leader) {
        this.leader = leader;
    }

    public void join(ArenaPlayer player) {
        if(player.getParty() == null) {
            players.add(player);
            player.setParty(this);
        }
    }

    public List<ArenaPlayer> getPlayers() {
        return players;
    }
}
