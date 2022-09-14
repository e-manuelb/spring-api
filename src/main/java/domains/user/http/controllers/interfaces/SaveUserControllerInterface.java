package domains.user.http.controllers.interfaces;

import domains.user.http.requests.SaveUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface SaveUserControllerInterface {
    public ResponseEntity<?> invoke(@RequestBody SaveUserRequest request);
}
