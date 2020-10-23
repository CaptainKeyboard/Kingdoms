package net.velion.arena.builder.builders.objectiveBuilder;

import net.velion.arena.Arena;
import net.velion.arena.IArenaEntity;
import net.velion.arena.capturing.CapturePoint;
import net.velion.arena.objective.CaptureObjective;

import java.util.Optional;

public class CaptureObjectiveBuilder extends ObjectiveBuilder {
    private String capturePoint;

    public CaptureObjectiveBuilder(String entity, String capturePoint) {
        super(entity);
        this.capturePoint = capturePoint;
    }

    @Override
    public CaptureObjective build(Arena arena) {
        Optional<IArenaEntity> entity1 = (Optional<IArenaEntity>) arena.getEntities().stream().filter(entity2 -> entity2.getName() == entity).findFirst();
        Optional<CapturePoint> capturePoint1 = arena.getCapturePoints().stream().filter(capturePoint2 -> capturePoint2.getName().equals(capturePoint)).findFirst();
        return new CaptureObjective(capturePoint1.get(), entity1.orElse(null));
    }
}
