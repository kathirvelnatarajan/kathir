package spring.classes;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class TestString {

@RequestMapping("/hello")
public String sayHi() {
	return "hi";
}
}
