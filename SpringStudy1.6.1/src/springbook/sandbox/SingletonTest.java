package springbook.sandbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
 
public class SingletonTest {
	public static void main(String[] args) {
		//스프링에서는 기본적으로 싱글톤레지스트리를 지원한다.
		//자바에서의 싱글톤패턴은 객체를 하나만 생성해서 이용하는 패턴이다.
		//하지만 IOC/DI 에서의 싱글톤패턴 구현은 복잡하고 코드의 가속성이 떨어진다.
		//하지만 스프링에서는 별도의 구현없이 자체적으로 싱글톤레지스트리가 탑재되어있어
		//기본적으로 bean을 생성하고 반환이 되면 같은 빈객체로 계속 반환되는걸 확인 할 수 있다.
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		System.out.println(context.getBean(UserDao.class));
		System.out.println(context.getBean(UserDao.class));
	}
} 
