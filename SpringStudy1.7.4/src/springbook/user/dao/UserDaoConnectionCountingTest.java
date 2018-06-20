package springbook.user.dao;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.domain.User;

public class UserDaoConnectionCountingTest {
	public static void main(String[] args) throws ClassNotFoundException,
			SQLException {
		//DAO가 DB에 얼마나 연결되는지를 파악하고싶다.
		//DAO makeConnection 메소드 모두를 변경 수정하기에 비용이 너무 많이든다.
		//그렇기 때문에 DI를 이용하여 DAO와 DB 커넥션 만드는 오브젝트 사이에 연결횟수를 카운팅하는 오브젝트를 
		//하나 더 추가하여 의존관계를 성립시켜준다.
		//DAO => counting => connection
		//위와같이 중간에 하나더 추가하여 DI를 성립 시켜준다.
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
