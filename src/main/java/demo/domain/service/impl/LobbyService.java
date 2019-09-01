package demo.domain.service.impl;

import demo.domain.datastore.IInMemoryCache;
import demo.domain.datastore.impl.InMemoryCache;
import demo.domain.service.ILobbyService;
import demo.valueobject.Lobby;
import demo.valueobject.record.UserLobbyRecord;
import demo.valueobject.id.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LobbyService implements ILobbyService {

    private final IInMemoryCache<UserId, UserLobbyRecord> cache;
    private final LocalDateTime lobbyStartTime = LocalDateTime.now();

//    @Value("${service.cache.capacity}")
    private Integer capacity = 1000;

    @Autowired
    public LobbyService() {
        this.cache = new InMemoryCache<>(this.capacity);
    }

    @Override
    public Lobby put(final UserId userId, final UserLobbyRecord value) {
        final UserLobbyRecord existingRecord = this.cache.get(userId);

        if (existingRecord == null) {
            this.cache.put(userId, value);
        } else {
            final UserLobbyRecord newRecord = new UserLobbyRecord(
                    value.getUserId(),
                    existingRecord.getFirstDateTime(),
                    value.getLastDateTime());
            this.cache.put(userId, newRecord);
        }

        return getLobbyResponse(cache.getAll());
    }

    @Override
    public Lobby getAll() {
        return getLobbyResponse(cache.getAll());
    }

    private Lobby getLobbyResponse(final List<UserLobbyRecord> userLobbyRecords) {
        return new Lobby(userLobbyRecords, this.lobbyStartTime, LocalDateTime.now());
    }
}
