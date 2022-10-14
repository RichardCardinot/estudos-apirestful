package br.org.serratec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // Com essa anotação o Spring passa a gerenciar essa classe
public class AppConfig {
	
	@Bean // Anotação que faz com que seja possível usar apenas o nome do método e não o nome da classe no autowired.
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
