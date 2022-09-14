package domains.user.http.controllers;

import domains.user.http.controllers.interfaces.SaveUserControllerInterface;
import domains.user.http.requests.SaveUserRequest;
import domains.user.models.User;
import domains.user.repositories.UserRepository;
import domains.user.services.SaveUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class SaveUserController implements SaveUserControllerInterface {
    @Autowired
    SaveUserService saveUserService;

    @PostMapping("/")
    public ResponseEntity<?> invoke(@RequestBody SaveUserRequest request) {
        try {
            User user = makeUser(request);
            return new ResponseEntity<>(saveUserService.handle(user), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
        }
    }

    protected User makeUser(SaveUserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
