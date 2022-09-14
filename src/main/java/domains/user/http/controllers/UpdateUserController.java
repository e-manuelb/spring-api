package domains.user.http.controllers;

import domains.user.http.controllers.interfaces.UpdateUserControllerInterface;
import domains.user.http.requests.UpdateUserRequest;
import domains.user.models.User;
import domains.user.services.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UpdateUserController implements UpdateUserControllerInterface {
    @Autowired
    UpdateUserService updateUserService;

    @PutMapping("/{id}")
    public ResponseEntity<?> invoke(@RequestBody UpdateUserRequest request, @PathVariable Integer id) {
        try {
            User user = makeUser(request);
            return new ResponseEntity<>(updateUserService.handle(user, id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("The update was not possible.", HttpStatus.NOT_FOUND);
        }
    }

    protected User makeUser(UpdateUserRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
