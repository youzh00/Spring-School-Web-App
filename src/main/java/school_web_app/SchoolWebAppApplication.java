package school_web_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("school_web_app.repository")
@EntityScan("school_web_app.model")
public class SchoolWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolWebAppApplication.class, args);
    }

}
