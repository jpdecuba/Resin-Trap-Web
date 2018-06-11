

import Controller.BackendController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = BackendController.class)
public class HoneypotApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoneypotApplication.class, args);
	}
}
