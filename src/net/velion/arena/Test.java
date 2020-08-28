package net.velion.arena;

import net.velion.Player;
import net.velion.arena.match.Match;
import net.velion.arena.match.Round;
import net.velion.arena.match.Stage;
import net.velion.arena.mode.Conquest;
import net.velion.arena.objectives.CaptureObjective;
import net.velion.arena.team.Team;
import net.velion.controlling.CapturePoint;
import net.velion.controlling.SpawnPoint;
import net.velion.party.Party;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*
        Conquest conquest = f.BasicConquest()
                .setTeams(
                        f.Team("RedTeam", 100),
                        f.Team("BlueTeam", 100)
                )
                .setSpawnPoints(
                        f.SpawnPoint(locationSPRed, "Red Spawn", "RedTeam"),
                        f.SpawnPoint(locationSPBlue, "Blue Spawn", "BlueTeam", "RedTeam"),
                        f.SpawnPoint(locationSPAll, "Spawn")
                )
                .setCapturePoints(
                        f.CapturePoint(locationCPA, "A"),
                        f.CapturePoint(locationCPB, "B"),
                        f.CapturePoint(locationCPC, "C"),
                        f.CapturePoint(locationCPD, "D"),
                        f.CapturePoint(locationCPE, "E"),
                        f.CapturePoint(locationCPF, "F")
                )
                .build();
        conquest.getClass();*/

        Arena arena = new Arena(true, 8, 16);

        Team redTeam = new Team("RedTeam", 100);
        Team blueTeam = new Team("BlueTeam", 100);
        List<Team> teams = Arrays.asList(redTeam, blueTeam);

        SpawnPoint redSpawn = new SpawnPoint(arena, null, "RedSpawn", Arrays.asList(redTeam));
        SpawnPoint blueSpawn = new SpawnPoint(arena, null, "BlueSpawn", Arrays.asList(blueTeam));
        List<SpawnPoint> spawnPoints = Arrays.asList(redSpawn, blueSpawn);

        CapturePoint cpA = new CapturePoint(arena, null, "A");
        CapturePoint cpB = new CapturePoint(arena, null, "B");
        CapturePoint cpC = new CapturePoint(arena, null, "C");
        CapturePoint cpD = new CapturePoint(arena, null, "D");
        CapturePoint cpE = new CapturePoint(arena, null, "E");
        CapturePoint cpF = new CapturePoint(arena, null, "F");
        List<CapturePoint> capturePoints = Arrays.asList(cpA, cpB, cpC, cpD, cpE, cpF);

        Match match = new Match();
        Round round1 = new Round();
        Stage stage1 = new Stage();

        stage1.addObjective(redTeam, new CaptureObjective(stage1, redTeam, cpA));
        stage1.addObjective(redTeam, new CaptureObjective(stage1, redTeam, cpB));
        stage1.addObjective(redTeam, new CaptureObjective(stage1, redTeam, cpC));
        stage1.addObjective(redTeam, new CaptureObjective(stage1, redTeam, cpD));
        stage1.addObjective(redTeam, new CaptureObjective(stage1, redTeam, cpE));
        stage1.addObjective(redTeam, new CaptureObjective(stage1, redTeam, cpF));

        stage1.addObjective(blueTeam, new CaptureObjective(stage1, blueTeam, cpA));
        stage1.addObjective(blueTeam, new CaptureObjective(stage1, blueTeam, cpB));
        stage1.addObjective(blueTeam, new CaptureObjective(stage1, blueTeam, cpC));
        stage1.addObjective(blueTeam, new CaptureObjective(stage1, blueTeam, cpD));
        stage1.addObjective(blueTeam, new CaptureObjective(stage1, blueTeam, cpE));
        stage1.addObjective(blueTeam, new CaptureObjective(stage1, blueTeam, cpF));

        round1.addStage(stage1);

        match.addRound(round1);

        Conquest conquest = new Conquest(match, teams, spawnPoints, capturePoints);

        arena.setArenaMode(conquest);

        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        Player player3 = new Player("Player3");
        Player player4 = new Player("Player4");
        Player player5 = new Player("Player5");
        Player player6 = new Player("Player6");
        Player player7 = new Player("Player7");
        Player player8 = new Player("Player8");
        Player player9 = new Player("Player9");
        Player player10 = new Player("Player10");

        Party party = new Party(player6);
        party.join(player7);
        party.join(player8);
        party.join(player9);

        arena.join(player1);
        arena.join(player2);
        arena.join(player3);
        arena.join(player4);
        arena.join(player5);
        arena.partyJoin(party);
        arena.join(player10);

        arena.start();

        cpA.claim(player1);
        cpB.claim(player3);
        cpC.claim(player1);
        cpD.claim(player1);
        cpE.claim(player1);
        cpF.claim(player1);


        System.out.println(blueTeam.getTeamScoreboard());
        System.out.println(redTeam.getTeamScoreboard());
    }
}
