package domains.user.services;

import domains.user.models.User;
import domains.user.repositories.UserRepository;
import domains.user.services.interfaces.ListUsersServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ListUsersService implements ListUsersServiceInterface {
    @Autowired
    protected UserRepository userRepository;

    public List<User> handle() {
        return userRepository.findAll();
    }
}
