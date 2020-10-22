package net.velion.arena.validation;

public class ArenaInvalidException extends Exception {
    public ArenaInvalidException(int messageID) {
        super(ValidationMessage.get(messageID));
    }
}
