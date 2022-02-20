package br.com.letscode.moviebattle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableFeignClients
@SpringBootApplication
public class MovieBattleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBattleApplication.class, args);
	}

}
