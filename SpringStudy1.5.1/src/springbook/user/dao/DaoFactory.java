package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//애노테이션을 이용하여 springframework사용
//@Configuration 이 클래스를 IOC설정 파일로 사용하겠다는 의미
@Configuration
public class DaoFactory {
	//@Bean 이 메소드를 이용하여 bean객체를 생성하여 반환하겠다는 의미
	@Bean
	public UserDao userDao() {
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}

	@Bean
	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
