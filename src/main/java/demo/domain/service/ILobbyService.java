package demo.domain.service;

import demo.valueobject.Lobby;
import demo.valueobject.record.UserLobbyRecord;
import demo.valueobject.id.UserId;

public interface ILobbyService {
    Lobby put(final UserId userId, final UserLobbyRecord value);

    Lobby getAll();
}
