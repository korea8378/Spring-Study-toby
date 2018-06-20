package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountingDaoFactory {
	//userDao가 CoutingConnectionMaker에 의존
	@Bean
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	//CoutingConnectionMaker가 DConnectionMaker에 의존
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}

	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new DConnectionMaker();
	}
}

