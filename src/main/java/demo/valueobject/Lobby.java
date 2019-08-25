package demo.valueobject;

import demo.valueobject.record.UserLobbyRecord;

import java.time.LocalDateTime;
import java.util.List;

public class Lobby {
    private final List<UserLobbyRecord> userLobbyRecords;
    private final LocalDateTime lobbyStartTime;
    private final LocalDateTime lobbyLastUpdateTime;

    public Lobby(final List<UserLobbyRecord> userLobbyRecords,
                 final LocalDateTime lobbyStartTime,
                 final LocalDateTime lobbyLastUpdateTime) {
        this.userLobbyRecords = userLobbyRecords;
        this.lobbyStartTime = lobbyStartTime;
        this.lobbyLastUpdateTime = lobbyLastUpdateTime;
    }

    public List<UserLobbyRecord> getUserLobbyRecords() {
        return userLobbyRecords;
    }

    public LocalDateTime getLobbyStartTime() {
        return lobbyStartTime;
    }

    public Integer getLobbySize() {
        return userLobbyRecords.size();
    }

    public LocalDateTime getLobbyLastUpdateTime() {
        return lobbyLastUpdateTime;
    }
}
