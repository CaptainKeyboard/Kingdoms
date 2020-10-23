package net.velion.arena.validation;

import java.util.HashMap;
import java.util.Map;

// TODO This whole damn class has to be replaced.
public class ValidationMessage {
    private static final Map<Integer, String> messages = new HashMap<>() {{
        put(1, "Arena: No round defined");
        put(2, "Round: No staging defined");
        put(3, "Staging: No default stage defined");
        put(4, "Stage: No ordersList defined");
        put(5, "OrderList: No orders defined");
        put(6, "Order: No objectives defined");
        put(7, "GlobalOrder: No objectives defined");
        put(8, "ComplexStaging: No stageMapping defined");
        put(9, "ParallelStaging: No stageMapping defined");
        put(10, "StageList: No stages defined");
        put(11, "Round: No conditions defined");
        put(101, "CaptureObjective: No capture point defined");
        put(102, "KillObjective: No kill goal defined");
        put(103, "ScoreObjective: No score goal defined");
    }};

    public static String get(int messageID) {
        return messages.get(messageID);
    }
}
