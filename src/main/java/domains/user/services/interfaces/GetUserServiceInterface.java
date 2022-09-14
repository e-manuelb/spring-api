package domains.user.services.interfaces;

import domains.user.models.User;

public interface GetUserServiceInterface {
    public User handle(Integer id);
}
