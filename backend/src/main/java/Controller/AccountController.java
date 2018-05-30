package Controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/api")
public class AccountController {

	@RequestMapping(path = "/Login", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody String addNewUser (@RequestParam String username, @RequestParam String password) {
		return username + " " + password;
	}
}
