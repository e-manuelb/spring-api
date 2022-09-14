package domains.user.services;

import domains.user.models.User;
import domains.user.repositories.UserRepository;
import domains.user.services.interfaces.SaveUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SaveUserService implements SaveUserServiceInterface {
    @Autowired
    UserRepository userRepository;

    public User handle(User user) {
        userRepository.save(user);

        return user;
    }
}
