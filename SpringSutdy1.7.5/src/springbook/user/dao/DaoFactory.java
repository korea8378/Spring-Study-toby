package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao() {
		//객체를 생성하고 set메소드를 호출하여 의존성을 주입시킨다.
		UserDao dao = new UserDao();
		dao.setConnectionMaker(connectionMaker());
		return dao;
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
