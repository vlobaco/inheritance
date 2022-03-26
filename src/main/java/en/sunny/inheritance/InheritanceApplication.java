package en.sunny.inheritance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ConfiguracionConJava.class)
public class InheritanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InheritanceApplication.class, args);
	}

}
