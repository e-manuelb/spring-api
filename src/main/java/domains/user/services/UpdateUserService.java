package domains.user.services;

import domains.user.models.User;
import domains.user.repositories.UserRepository;
import domains.user.services.interfaces.UpdateUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UpdateUserService implements UpdateUserServiceInterface {
    @Autowired
    protected UserRepository userRepository;

    public User handle(User user, Integer id) {
        User existUser = userRepository.findById(id).get();

        if (user.getName() != null) {
            existUser.setName(user.getName());
        }

        if (user.getEmail() != null) {
            existUser.setEmail(user.getEmail());
        }

        if (user.getPassword() != null) {
            existUser.setPassword(user.getPassword());
        }

        userRepository.save(existUser);

        return existUser;
    }
}
