package net.roma.librarydemo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "net.roma.librarydemo.repository")
@EntityScan(basePackages = "net.roma.librarydemo.model")
public class ApplicationLibrary {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationLibrary.class);
    }

}
