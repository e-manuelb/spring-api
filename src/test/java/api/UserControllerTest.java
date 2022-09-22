package api;

import com.api.config.security.SecurityConfig;
import com.api.http.controllers.UserController;
import com.api.models.User;
import com.api.repositories.UserRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Instant;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {SpringApiApplicationTests.class, SecurityConfig.class})
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Before("")
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void findAll() throws Exception {
        User[] user = {
                new User(1, "John Doe", "email@email.com", 2, "123456", Instant.now(), Instant.now()),
                new User(2, "John Doe", "email@email.com", 2, "123456", Instant.now(), Instant.now()),
                new User(3, "John Doe", "email@email.com", 2, "123456", Instant.now(), Instant.now())
        };

        List<User> userList = List.of(user);

        when(userRepository.findAll()).thenReturn(userList);

        this.mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("email@email.com")));
    }
}
