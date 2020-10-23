package net.velion.arena.builder;

import net.velion.arena.Arena;
import net.velion.arena.Player;
import net.velion.arena.builder.builders.*;
import net.velion.arena.builder.builders.conditionBuilder.ConditionBuilder;
import net.velion.arena.builder.builders.conditionBuilder.LastStageConditionBuilder;
import net.velion.arena.builder.builders.conditionBuilder.ScoreConditionBuilder;
import net.velion.arena.builder.builders.conditionBuilder.TimeConditionBuilder;
import net.velion.arena.builder.builders.objectiveBuilder.CaptureObjectiveBuilder;
import net.velion.arena.builder.builders.objectiveBuilder.ObjectiveBuilder;
import net.velion.arena.builder.builders.orderBuilder.GlobalOrderBuilder;
import net.velion.arena.builder.builders.roundBuilder.RoundBuilder;
import net.velion.arena.builder.builders.stagingBuilder.ComplexStagingBuilder;
import net.velion.arena.builder.builders.stagingBuilder.StageBuilder;
import net.velion.arena.builder.builders.stagingBuilder.StageListBuilder;
import net.velion.arena.builder.builders.stagingBuilder.StagingBuilder;
import net.velion.arena.capturing.CapturePoint;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ArenaLoader {
    public static void main(String[] args) throws Exception {
        File file = new File("templates/arenaTemplate.arena");
        Arena arena = load(file);

        List<CapturePoint> capturePoints = arena.getCapturePoints();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");
        Player player5 = new Player("Player 5");
        Player player6 = new Player("Player 6");

        arena.join(player1);
        arena.join(player2);
        arena.join(player3);
        arena.join(player4);
        arena.join(player5);
        arena.join(player6);

        arena.start();

        arena.capture(capturePoints.get(0), player1);
        arena.capture(capturePoints.get(1), player1);
        arena.capture(capturePoints.get(2), player1);
        arena.capture(capturePoints.get(3), player1);
    }

    public static Arena load(File file) throws Exception {
        FileReader fileReader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();
        JSONObject arenaJSON = (JSONObject) jsonParser.parse(fileReader);
        ArenaBuilder arenaBuilder = loadArena(arenaJSON);
        return arenaBuilder.build();
    }

    public static ArenaBuilder loadArena(JSONObject arenaJSON) throws Exception {
        ArenaBuilder arenaBuilder = null;
        if (arenaJSON.containsKey("name")) {
            String arenaName = (String) arenaJSON.get("name");
            if (arenaJSON.containsKey("type")) {
                String arenaType = (String) arenaJSON.get("type");
                if (arenaType.equals("team arena")) {
                    arenaBuilder = new TeamArenaBuilder(arenaName);
                    if (arenaJSON.containsKey("teams")) {
                        JSONArray teamJSON = (JSONArray) arenaJSON.get("teams");
                        ((TeamArenaBuilder) arenaBuilder).setTeams(loadTeams(teamJSON));
                    } else {
                        throw new Exception();
                    }
                } else if (arenaType.equals("solo arena")) {
                    arenaBuilder = new SoloArenaBuilder(arenaName);
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
        if (arenaJSON.containsKey("capture_points")) {
            JSONArray capturePointsJSON = (JSONArray) arenaJSON.get("capture_points");
            arenaBuilder.setCapturePoint(loadCapturePoints(capturePointsJSON));
        }
        if (arenaJSON.containsKey("rounds")) {
            JSONArray roundsJSON = (JSONArray) arenaJSON.get("rounds");
            arenaBuilder.setRounds(loadRounds(roundsJSON));
        } else {
            throw new Exception();
        }
        return arenaBuilder;
    }

    public static List<TeamBuilder> loadTeams(JSONArray teamsJSON) throws Exception {
        List<TeamBuilder> teamBuilders = new ArrayList<>();
        for (Object team : teamsJSON) {
            JSONObject teamJSON = (JSONObject) team;
            teamBuilders.add(loadTeam(teamJSON));
        }
        return teamBuilders;
    }

    public static TeamBuilder loadTeam(JSONObject teamJSON) throws Exception {
        TeamBuilder teamBuilder = null;
        if (teamJSON.containsKey("name")) {
            String teamName = (String) teamJSON.get("name");
            teamBuilder = new TeamBuilder(teamName);
        } else {
            throw new Exception();
        }
        return teamBuilder;
    }

    public static List<CapturePointBuilder> loadCapturePoints(JSONArray capturePointsJSON) throws Exception {
        List<CapturePointBuilder> capturePointBuilders = new ArrayList<>();
        for (Object capturePoint : capturePointsJSON) {
            JSONObject capturePointJSON = (JSONObject) capturePoint;
            capturePointBuilders.add(loadCapturePoint(capturePointJSON));
        }
        return capturePointBuilders;
    }

    public static CapturePointBuilder loadCapturePoint(JSONObject capturePointJSON) throws Exception {
        CapturePointBuilder capturePointBuilder = null;
        if (capturePointJSON.containsKey("name")) {
            String capturePointName = (String) capturePointJSON.get("name");
            capturePointBuilder = new CapturePointBuilder(capturePointName);
        } else {
            throw new Exception();
        }
        return capturePointBuilder;
    }

    public static List<RoundBuilder> loadRounds(JSONArray roundsJSON) throws Exception {
        List<RoundBuilder> roundBuilders = new ArrayList<>();
        for (Object round : roundsJSON) {
            JSONObject roundJSON = (JSONObject) round;
            roundBuilders.add(loadRound(roundJSON));
        }
        return roundBuilders;
    }

    public static RoundBuilder loadRound(JSONObject roundJSON) throws Exception {
        RoundBuilder roundBuilder = new RoundBuilder();
        if (roundJSON.containsKey("conditions")) {
            JSONArray conditionsJSON = (JSONArray) roundJSON.get("conditions");
            roundBuilder.setConditions(loadConditions(conditionsJSON));
        } else {
            throw new Exception();
        }
        if (roundJSON.containsKey("staging")) {
            JSONObject stagingJSON = (JSONObject) roundJSON.get("staging");
            roundBuilder.setStaging(loadStaging(stagingJSON));
        } else {
            throw new Exception();
        }
        return roundBuilder;
    }

    public static StagingBuilder loadStaging(JSONObject stagingJSON) throws Exception {
        StagingBuilder stagingBuilder = null;
        if (stagingJSON.containsKey("type")) {
            String stagingType = (String) stagingJSON.get("type");
            if (stagingType.equals("complex staging")) {
                stagingBuilder = new ComplexStagingBuilder();
                if (stagingJSON.containsKey("stage_mapping")) {
                    JSONArray stageMappingJSON = (JSONArray) stagingJSON.get("stage_mapping");
                    ((ComplexStagingBuilder) stagingBuilder).setStageMapping(loadStageMapping(stageMappingJSON));
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
        if (stagingJSON.containsKey("default_stage")) {
            JSONObject defaultStageJSON = (JSONObject) stagingJSON.get("default_stage");
            StageBuilder defaultStage = loadStage(defaultStageJSON);
            stagingBuilder.setDefaultStage(defaultStage);
        } else {
            throw new Exception();
        }
        return stagingBuilder;
    }

    public static List<StageListBuilder> loadStageMapping(JSONArray stageMappingJSON) throws Exception {
        List<StageListBuilder> stageMapping = new ArrayList<>();
        for (Object stageMappingEntry : stageMappingJSON) {
            JSONObject stageMappingEntryJSON = (JSONObject) stageMappingEntry;
            stageMapping.add(loadStageMapEntry(stageMappingEntryJSON));
        }
        return stageMapping;
    }

    public static StageListBuilder loadStageMapEntry(JSONObject stageMappingEntryJSON) throws Exception {
        StageListBuilder stageListBuilder = null;
        if (stageMappingEntryJSON.containsKey("entity")) {
            String entity = (String) stageMappingEntryJSON.get("entity");
            stageListBuilder = new StageListBuilder(entity);
            if (stageMappingEntryJSON.containsKey("stages")) {
                JSONArray stagesJSON = (JSONArray) stageMappingEntryJSON.get("stages");
                stageListBuilder.setStages(loadStages(stagesJSON));
            } else {
                throw new Exception();
            }
        } else {
            throw new Exception();
        }
        return stageListBuilder;
    }

    public static List<StageBuilder> loadStages(JSONArray stagesJSON) throws Exception {
        List<StageBuilder> stageBuilders = new ArrayList<>();
        for (Object stage : stagesJSON) {
            JSONObject stageJSON = (JSONObject) stage;
            stageBuilders.add(loadStage(stageJSON));
        }
        return stageBuilders;
    }

    public static StageBuilder loadStage(JSONObject stageJSON) throws Exception {
        StageBuilder stageBuilder = null;
        if (stageJSON.containsKey("name")) {
            String stageName = (String) stageJSON.get("name");
            stageBuilder = new StageBuilder(stageName);
            if (stageJSON.containsKey("global_order")) {
                JSONObject globalOrderJSON = (JSONObject) stageJSON.get("global_order");
                stageBuilder.setGlobalOrder(loadGlobalOrder(globalOrderJSON));
            }
        } else {
            throw new Exception();
        }
        return stageBuilder;
    }

    public static GlobalOrderBuilder loadGlobalOrder(JSONObject globalOrderJSON) throws Exception {
        GlobalOrderBuilder globalOrderBuilder = new GlobalOrderBuilder();
        if (globalOrderJSON.containsKey("objectives")) {
            JSONArray objectivesJSON = (JSONArray) globalOrderJSON.get("objectives");
            List<ObjectiveBuilder> objectiveBuilders = loadObjectives(objectivesJSON);
            globalOrderBuilder.setObjectives(objectiveBuilders);
        } else {
            throw new Exception();
        }
        return globalOrderBuilder;
    }

    public static List<ObjectiveBuilder> loadObjectives(JSONArray objectivesJSON) throws Exception {
        List<ObjectiveBuilder> objectiveBuilders = new ArrayList<>();
        for (Object objective : objectivesJSON) {
            JSONObject objectiveJSON = (JSONObject) objective;
            ObjectiveBuilder objectiveBuilder = null;
            if (objectiveJSON.containsKey("type")) {
                String objectiveType = (String) objectiveJSON.get("type");
                if (objectiveType.equals("capture objective")) {
                    if (objectiveJSON.containsKey("capture_point")) {
                        String capturePoint = (String) objectiveJSON.get("capture_point");
                        objectiveBuilder = new CaptureObjectiveBuilder(null, capturePoint);
                    } else {
                        throw new Exception();
                    }
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
            objectiveBuilders.add(objectiveBuilder);
        }
        return objectiveBuilders;
    }

    public static List<ConditionBuilder> loadConditions(JSONArray conditionsJSON) throws Exception {
        List<ConditionBuilder> conditionBuilders = new ArrayList<>();
        for (Object condition : conditionsJSON) {
            JSONObject conditionJSON = (JSONObject) condition;
            conditionBuilders.add(loadCondition(conditionJSON));
        }
        return conditionBuilders;
    }

    public static ConditionBuilder loadCondition(JSONObject conditionJSON) throws Exception {
        ConditionBuilder conditionBuilder = null;
        if (conditionJSON.containsKey("type")) {
            String conditionType = (String) conditionJSON.get("type");
            if (conditionType.equals("time condition")) {
                if (conditionJSON.containsKey("time")) {
                    long time = (long) conditionJSON.get("time");
                    conditionBuilder = new TimeConditionBuilder((int) time);
                } else {
                    throw new Exception();
                }
            } else if (conditionType.equals("last stage condition")) {
                conditionBuilder = new LastStageConditionBuilder();
            } else if (conditionType.equals("score condition")) {
                if (conditionJSON.containsKey("goal")) {
                    long goal = (long) conditionJSON.get("goal");
                    conditionBuilder = new ScoreConditionBuilder((int) goal);
                } else {
                    throw new Exception();
                }
            } else {
                throw new Exception();
            }
            if (conditionJSON.containsKey("evaluation")) {
                boolean evaluation = (boolean) conditionJSON.get("evaluation");
                conditionBuilder.setEvaluation(evaluation);
            }
            if (conditionJSON.containsKey("ignore")) {
                boolean ignore = (boolean) conditionJSON.get("ignore");
                conditionBuilder.setIgnore(ignore);
            }
        } else {
            throw new Exception();
        }
        return conditionBuilder;
    }
}
