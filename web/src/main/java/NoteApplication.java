import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"ru.gb.*"})
@EntityScan(basePackages = {"ru.gb.*"})
@EnableJpaRepositories(basePackages = {"ru.gb.*"})
public class NoteApplication {

    public static void main(String[] args) {

        SpringApplication.run(NoteApplication.class);
    }
}