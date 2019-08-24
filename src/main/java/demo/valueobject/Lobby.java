package demo.valueobject;

import demo.valueobject.record.UserLobbyRecord;

import java.time.LocalDateTime;
import java.util.List;

public class Lobby {
    private final List<UserLobbyRecord> userLobbyRecords;
    private final LocalDateTime lobbyStartTime;

    public Lobby(final List<UserLobbyRecord> userLobbyRecords, final LocalDateTime lobbyStartTime) {
        this.userLobbyRecords = userLobbyRecords;
        this.lobbyStartTime = lobbyStartTime;
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
}
