package de.codeboje.springbootbook.commentstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Configuration
@RestController
@EnableTransactionManagement
@EntityScan(basePackages = { "de.codeboje.springbootbook" })
@ComponentScan(basePackages = { "de.codeboje.springbootbook", "de.codeboje.springbootbook.spamdetection" })
public class CommentStoreApp {

	public static void main(String[] args) {
		SpringApplication.run(CommentStoreApp.class, args);

	}

	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}

}
