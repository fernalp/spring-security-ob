package comfernandoalmanza.jwtspringsecurity;

import comfernandoalmanza.jwtspringsecurity.entities.User;
import comfernandoalmanza.jwtspringsecurity.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class JwtSpringSecurityApplication {

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JwtSpringSecurityApplication.class, args);

		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

		User user = new User(null, "fernalp", encoder.encode("123456"));
		UserRepository repository = context.getBean(UserRepository.class);

		repository.save(user);
		System.out.println(repository.count());

		User user2 = new User(null, "fernal", encoder.encode("123456"));
		repository.save(user2);
		System.out.println(repository.count());

	}

}
