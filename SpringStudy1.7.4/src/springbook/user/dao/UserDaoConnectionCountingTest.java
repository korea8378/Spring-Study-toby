package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		//DAO�� DB�� �󸶳� ����Ǵ����� �ľ��ϰ�ʹ�.
		//DAO makeConnection �޼ҵ� ��θ� ���� �����ϱ⿡ ����� �ʹ� ���̵��.
		//�׷��� ������ DI�� �̿��Ͽ� DAO�� DB Ŀ�ؼ� ����� ������Ʈ ���̿� ����Ƚ���� ī�����ϴ� ������Ʈ�� 
		//�ϳ� �� �߰��Ͽ� �������踦 ���������ش�.
		//DAO => counting => connection
		//���Ͱ��� �߰��� �ϳ��� �߰��Ͽ� DI�� ���� �����ش�.
		AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(CountingDaoFactory.class);		
		UserDao dao = context.getBean("userDao", UserDao.class);

		for(int i=0; i<10; i++) {
			User user = new User();
			user.setId(""+i);
			user.setName(""+i);
			user.setPassword(""+i);
			dao.add(user);
		}

		CountingConnectionMaker ccm =  context.getBean("connectionMaker", CountingConnectionMaker.class);
		System.out.println("Connection counter : " + ccm.getCounter());		
	}
}
