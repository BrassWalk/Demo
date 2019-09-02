package demo.service.impl;

import demo.service.IUserService;
import demo.valueobject.entity.UserModel;
import demo.valueobject.id.UserId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {

    private final Map<UserId, UserModel> users;

    @Autowired
    public UserService() {
        this.users = new HashMap<>();
    }

    @Override
    public UserModel createUser(final UserModel userModel) {
        this.users.put(userModel.getUserId(), userModel);
        return users.get(userModel.getUserId());
    }

    @Override
    public UserModel readUser(final UserId userId) {
        return users.get(userId);
    }

    @Override
    public List<UserModel> readUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public UserModel updateUser(final UserModel userModel) {
        this.users.put(userModel.getUserId(), userModel);
        return users.get(userModel.getUserId());
    }

    @Override
    public void deleteUser(final UserId userId) {
        users.remove(userId);
    }
}
