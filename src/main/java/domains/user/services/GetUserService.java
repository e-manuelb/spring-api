package domains.user.services;

import domains.user.models.User;
import domains.user.repositories.UserRepository;
import domains.user.services.interfaces.GetUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class GetUserService implements GetUserServiceInterface {
    @Autowired
    protected UserRepository userRepository;

    public User handle(Integer id) {
        return userRepository.findById(id).get();
    }
}
