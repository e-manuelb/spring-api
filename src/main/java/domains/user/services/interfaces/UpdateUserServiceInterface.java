package domains.user.services.interfaces;

import domains.user.models.User;

public interface UpdateUserServiceInterface {
    public User handle(User user, Integer id);
}
