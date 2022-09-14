package domains.user.http.controllers;

import domains.user.http.controllers.interfaces.DeleteUserControllerInterface;
import domains.user.services.DeleteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class DeleteUserController implements DeleteUserControllerInterface {
    @Autowired
    DeleteUserService deleteUserService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> invoke(@PathVariable Integer id) {
        try {
            deleteUserService.handle(id);
            return new ResponseEntity<>("The user was deleted.", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Something went wrong, please try again.", HttpStatus.BAD_REQUEST);
        }
    }
}
