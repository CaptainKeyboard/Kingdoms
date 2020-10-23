import net.velion.arena.Team;
import net.velion.arena.TeamArena;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeamArenaTest {
    @Test
    public void shouldHaveEntities() {
        TeamArena teamArena = new TeamArena("Team Arena 1");
        Team redTeam = new Team("Team 1");
        Team blueTeam = new Team("Team 2");
        Team greenTeam = new Team("Team 3");

        teamArena.addTeam(redTeam);
        teamArena.addTeam(blueTeam);
        teamArena.addTeam(greenTeam);

        assertEquals(3, teamArena.getEntities().size());
    }
}
