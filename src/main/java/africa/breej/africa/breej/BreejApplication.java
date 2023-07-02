package africa.breej.africa.breej;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BreejApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreejApplication.class, args);
	}

}

@RestController
@RequestMapping("/api")
class MyController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello, World!";
	}
}
