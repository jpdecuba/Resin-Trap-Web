package Controller;

import Shared.Logging.LogConnection;
import Shared.Model.User;
import Shared.Model.UserRole;
import Sockets.SocketClient;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Set;

@RestController()
@RequestMapping("/api")
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    private static final SocketClient client = new SocketClient(null);

    @RequestMapping(path = "/inlog", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Boolean addNewUser(@RequestParam String username, @RequestParam String password) {
        User user = client.Login(new User(username, password));
        boolean check = (user != null);
        return check;
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    Boolean registerNewUser(@RequestBody User user) {
        User u;
        boolean create = false;
        if (user.getRole() == UserRole.Admin) {
            u = new User(user.getName(), user.getPassword(), UserRole.Admin);
            u.addEmail(user.getMsgEmail().get(0));
            create = client.Register(u);
            System.out.println(create);
            return create;
        } else if (user.getRole() == UserRole.User) {
            u = new User(user.getName(), user.getPassword(), UserRole.User, user.getCode());
            u.addEmail(user.getMsgEmail().get(0));
            create = client.Register(u);
            System.out.println(create);
            return create;
        }
        return create;


    }

    @RequestMapping(path = "/download/resin", method = RequestMethod.GET)
    public ResponseEntity<Resource> download() throws IOException {
        File file = new File("resintrap.zip");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok()
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/zip"))
                .body(resource);

    }


	@RequestMapping(path = "/logs", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody Set<LogConnection> Getlogs (@RequestBody User usr) {
		Set<LogConnection> create = client.GetlogFiles(usr);
		return create;
	}

    @RequestMapping(path = "/ChangePassword", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody boolean ChangePassword (@RequestBody User usr, String password) {

        boolean bool = client.ChangePassword(password,usr.getId());
        return bool;
    }

}
