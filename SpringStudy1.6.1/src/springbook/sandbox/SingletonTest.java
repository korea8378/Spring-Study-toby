package springbook.sandbox;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springbook.user.dao.DaoFactory;
import springbook.user.dao.UserDao;
 
public class SingletonTest {
	public static void main(String[] args) {
		//������������ �⺻������ �̱��淹����Ʈ���� �����Ѵ�.
		//�ڹٿ����� �̱��������� ��ü�� �ϳ��� �����ؼ� �̿��ϴ� �����̴�.
		//������ IOC/DI ������ �̱������� ������ �����ϰ� �ڵ��� ���Ӽ��� ��������.
		//������ ������������ ������ �������� ��ü������ �̱��淹����Ʈ���� ž��Ǿ��־�
		//�⺻������ bean�� �����ϰ� ��ȯ�� �Ǹ� ���� ��ü�� ��� ��ȯ�Ǵ°� Ȯ�� �� �� �ִ�.
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		
		System.out.println(context.getBean(UserDao.class));
		System.out.println(context.getBean(UserDao.class));
	}
} 
