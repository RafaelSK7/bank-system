package rafael.kiss.sistemabancariodev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@EnableMongoRepositories()
public class SistemaBancarioDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaBancarioDevApplication.class, args);
	}

}
