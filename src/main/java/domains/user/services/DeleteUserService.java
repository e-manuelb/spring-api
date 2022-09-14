package domains.user.services;

import domains.user.repositories.UserRepository;
import domains.user.services.interfaces.DeleteUserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class DeleteUserService implements DeleteUserServiceInterface {
    @Autowired
    protected UserRepository userRepository;

    public void handle(Integer id) {
        userRepository.deleteById(id);
    }
}
