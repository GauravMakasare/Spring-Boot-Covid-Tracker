package covidtracker.io.Coronavirus1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Coronavirus1Application {

    public static void main(String[] args) {
        SpringApplication.run(Coronavirus1Application.class, args);
    }

}
