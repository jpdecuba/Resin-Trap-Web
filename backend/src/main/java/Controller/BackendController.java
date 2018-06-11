package Controller;

import Shared.Model.User;
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
    Boolean registerNewUser(@RequestBody User usr) {
        boolean create = client.Register(usr);
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

}
