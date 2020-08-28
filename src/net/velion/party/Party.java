package net.velion.party;

import net.velion.Player;

import java.util.ArrayList;
import java.util.List;

public class Party {
    final List<Player> members;
    Player leader;

    public Party(Player leader) {
        this.leader = leader;
        members = new ArrayList<>();
        members.add(leader);
    }

    public List<Player> getMembers() {
        return members;
    }

    public Player getLeader() {
        return leader;
    }

    public void join(Player player) {
        members.add(player);
    }

    public boolean leave(Player player) {
        members.remove(player);
        if(members.isEmpty()) {
            return false;
        }
        if(leader == player) {
            leader = members.get(0);
        }
        return true;
    }

    public int size() {
        return members.size();
    }
}
