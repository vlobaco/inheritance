package en.sunny.inheritance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("config/jpa-config.xml")
@Import(ConfiguracionConJava.class)
public class InheritanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InheritanceApplication.class, args);
	}

}
