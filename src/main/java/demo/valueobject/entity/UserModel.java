package demo.valueobject.entity;

import demo.valueobject.id.UserId;

import java.io.Serializable;

public class UserModel implements Serializable {
    UserId userId;
    String userName;

    public UserModel(final UserId userId, final String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
