package domains.user.http.controllers;

import domains.user.http.controllers.interfaces.GetUserControllerInterface;
import domains.user.models.User;
import domains.user.services.GetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class GetUserController implements GetUserControllerInterface {
    @Autowired
    GetUserService getUserService;

    @GetMapping("/{id}")
    public ResponseEntity<?> invoke(@PathVariable Integer id) {
        try {
            User user = getUserService.handle(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
