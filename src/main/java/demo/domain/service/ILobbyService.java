package demo.domain.service;

import demo.valueobject.LobbyRecord;
import demo.valueobject.id.UserId;

import java.util.List;

public interface ILobbyService {
    List<LobbyRecord> put(final UserId userId, final LobbyRecord value);

    List<LobbyRecord> getAll();
}
