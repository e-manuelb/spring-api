package domains.user.http.controllers;

import domains.user.http.controllers.interfaces.ListUsersControllerInterface;
import domains.user.models.User;
import domains.user.services.ListUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class ListUsersController implements ListUsersControllerInterface {
    @Autowired
    ListUsersService listUsersService;

    @GetMapping("/")
    public List<User> invoke() {
        return listUsersService.handle();
    }
}
