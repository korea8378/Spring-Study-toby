package springbook.user.dao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import springbook.user.domain.User;
 
public class UserDaoTest {
	//JUNIT�� �̿��� ���� test
	//���α׷��� ����� ���ư����� Ȯ�� �ϱ����ؼ��� ���� ������ �ϰų� test�� ���� Ȯ�� �� �� �ִ�.
	//���� �����Ͽ� Ȯ���ϱ⿡�� ���α׷��� ũ�ų� ���� Ȯ�� �� �ʿ���� �κб����� Ȯ���ؾ��Ѵ�
	//���� �ڽ��� ������ �ʴ� �κп��� �������� �߻��ϸ� ���ϴ� �κп����� Ȯ���� ����������� �ִ�
	//�׷��⶧���� �����׽�Ʈ�� �̿��Ͽ� ���� �κ����� ������ �׽�Ʈ�� �����Ѵ�
	//���� ������ ������ �ϳ��� Ȯ���� �Ѵٸ� �ᱹ ū �帧���� ������ ������ ������� ���� �Ҽ� �ִ�.
	//�����׽�Ʈ �����ӿ�ũ�� junit�� �̿��Ͽ� test�� �� �� �ִ�
	//�����ӿ�ũ�� �߰��ϰ� test ������̼��� �̿��Ͽ� �׽�Ʈ �Һκ��� üũ���ش�
	//assertThat �޼ҵ带 �̿��Ͽ� ������ ���� ���� �ִ�.
	//main() �޼ҵ带 �ϳ� �����Ͽ� �׽�Ʈ�� Ŭ������ ��ġ�� �־� ��������ָ� consoleâ�� ģ���� ���� �Ǵ� ���� 
	//ǥ�����ش�.	
	@Test 
	public void andAndGet() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("gyumee11");
		user.setName("�ڼ�ö");
		user.setPassword("springno1");

		dao.add(user);
			
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
	}
	
	public static void main(String[] args) {
		JUnitCore.main("springbook.user.dao.UserDaoTest");
	}
}
