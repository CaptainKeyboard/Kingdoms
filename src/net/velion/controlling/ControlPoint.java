package net.velion.controlling;

import net.velion.arena.Arena;
import net.velion.arena.team.Team;

public class ControlPoint {
    final Arena arena;
    final Location location;
    final String name;

    public ControlPoint(Arena arena, Location location, String name) {
        this.arena = arena;
        this.location = location;
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }
}
