package domains.user.http.controllers.interfaces;

import domains.user.models.User;

import java.util.List;

public interface ListUsersControllerInterface {
    public List<User> invoke();
}
