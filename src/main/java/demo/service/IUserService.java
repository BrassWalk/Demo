package demo.service;

import demo.valueobject.entity.UserModel;
import demo.valueobject.id.UserId;

import java.util.List;

public interface IUserService {

    UserModel createUser(final UserModel userModel);

    UserModel readUser(final UserId userId);

    List<UserModel> readUsers();

    UserModel updateUser(final UserModel userModel);

    void deleteUser(final UserId userId);
}
