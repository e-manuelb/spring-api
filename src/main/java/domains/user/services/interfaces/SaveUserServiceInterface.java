package domains.user.services.interfaces;

import domains.user.models.User;

public interface SaveUserServiceInterface {
    public User handle(User user);
}
