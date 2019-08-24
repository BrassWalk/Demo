package demo.valueobject;

import demo.valueobject.id.UserId;

import java.time.LocalDateTime;

public class LobbyRecord {
    private final UserId userId;
    private final LocalDateTime firstDateTime;
    private final LocalDateTime lastDateTime;

    public LobbyRecord(final UserId userId, final LocalDateTime firstDateTime, final LocalDateTime lastDateTime) {
        this.userId = userId;
        this.firstDateTime = firstDateTime;
        this.lastDateTime = lastDateTime;
    }

    public LobbyRecord(final UserId userId, final LocalDateTime lastDateTime) {
        this.userId = userId;
        this.firstDateTime = lastDateTime;
        this.lastDateTime = lastDateTime;
    }

    public UserId getUserId() {
        return userId;
    }

    public LocalDateTime getFirstDateTime() {
        return firstDateTime;
    }

    public LocalDateTime getLastDateTime() {
        return lastDateTime;
    }
}
