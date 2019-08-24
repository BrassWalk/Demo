package demo.domain.service.impl;

import demo.domain.datastore.IInMemoryCache;
import demo.domain.datastore.impl.InMemoryCache;
import demo.domain.service.ILobbyService;
import demo.valueobject.LobbyRecord;
import demo.valueobject.id.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LobbyService implements ILobbyService {

    private final IInMemoryCache<UserId, LobbyRecord> cache;

    // ToDo - add as configuration
    private static final int capacity = 1000;

    @Autowired
    public LobbyService() {
        this.cache = new InMemoryCache<>(capacity);
    }

    @Override
    public List<LobbyRecord> put(final UserId userId, final LobbyRecord value) {
        final LobbyRecord existingRecord = this.cache.get(userId);

        if (existingRecord == null) {
            this.cache.put(userId, value);
        } else {
            final LobbyRecord newRecord = new LobbyRecord(
                    value.getUserId(),
                    existingRecord.getFirstDateTime(),
                    value.getLastDateTime());
            this.cache.put(userId, newRecord);
        }

        return cache.getAll();
    }

    @Override
    public List<LobbyRecord> getAll() {
        return cache.getAll();
    }
}
