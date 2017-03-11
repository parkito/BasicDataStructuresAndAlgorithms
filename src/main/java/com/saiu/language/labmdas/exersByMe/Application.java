package com.saiu.language.labmdas.exersByMe;

import com.saiu.language.labmdas.exersByMe.dataForExers.Citizen;
import com.saiu.language.labmdas.exersByMe.dataForExers.CitizenRepository;
import com.saiu.language.labmdas.exersByMe.dataForExers.Sex;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Artem Karnov @date 11.03.17.
 *         artem.karnov@t-systems.com
 */

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CitizenRepository repository) {
        return (args) -> {
            repository.save(new Citizen("Ivan", "Ivanov", "Ivnovich",
                    null, null, 20,
                    Sex.MALE, null, null));
        };
    }
}
