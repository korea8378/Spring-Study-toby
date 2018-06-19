package springbook.user.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//�ֳ����̼��� �̿��Ͽ� springframework���
//@Configuration �� Ŭ������ IOC���� ���Ϸ� ����ϰڴٴ� �ǹ�
@Configuration
public class DaoFactory {
	//@Bean �� �޼ҵ带 �̿��Ͽ� bean��ü�� �����Ͽ� ��ȯ�ϰڴٴ� �ǹ�
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
