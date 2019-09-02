package demo.valueobject.id;

import java.util.Objects;
import java.util.UUID;

public class UserId {
    private String userId;

    public UserId() {
        this.userId = UUID.randomUUID().toString();
    }

    public UserId(final UUID uuid) {
        this.userId = uuid.toString();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final UserId other = (UserId) o;
        return Objects.equals(this.userId, other.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userId);
    }

    @Override
    public String toString() {
        return this.userId;
    }
}
