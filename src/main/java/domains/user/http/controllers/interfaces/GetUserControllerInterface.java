package domains.user.http.controllers.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface GetUserControllerInterface {
    public ResponseEntity<?> invoke(@PathVariable Integer id);
}
