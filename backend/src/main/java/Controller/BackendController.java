package Controller;

import Shared.Model.User;
import Sockets.SocketClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController()
@RequestMapping("/api")
public class BackendController {

	private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

	public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

	private static final SocketClient client = new SocketClient(null);

	@RequestMapping(path = "/inlog", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Boolean addNewUser (@RequestParam String username, @RequestParam String password) {
		User user = client.Login(new User(username, password));
		boolean check = (user != null);
		return check;
	}
}
