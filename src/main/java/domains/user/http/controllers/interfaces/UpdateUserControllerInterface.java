package domains.user.http.controllers.interfaces;

import domains.user.http.requests.UpdateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface UpdateUserControllerInterface {
    public ResponseEntity<?> invoke(@RequestBody UpdateUserRequest user, @PathVariable Integer id);
}
