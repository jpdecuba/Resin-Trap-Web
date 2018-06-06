package Controller;

import Shared.Logging.LogConnection;
import Shared.Model.User;
import Sockets.SocketClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

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

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Boolean registerNewUser (@RequestBody User usr) {
		boolean create = client.Register(usr);
		return create;
	}


	@RequestMapping(path = "/logs", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Set<LogConnection> Getlogs (@RequestBody User usr) {
		Set<LogConnection> create = client.GetlogFiles(usr);
		return create;
	}

}
