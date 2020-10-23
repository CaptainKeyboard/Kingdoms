package net.velion.arena.builder.builders;

import net.velion.arena.capturing.CapturePoint;

public class CapturePointBuilder {
    private String name;

    public CapturePointBuilder(String name) {
        this.name = name;
    }

    public CapturePoint build() {
        return new CapturePoint(name);
    }
}
