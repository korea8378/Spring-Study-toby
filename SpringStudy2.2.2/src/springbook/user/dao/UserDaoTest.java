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
	//JUNIT을 이용한 단위 test
	//프로그램이 제대로 돌아가는지 확인 하기위해서는 직접 실행을 하거나 test를 거쳐 확인 할 수 있다.
	//직접 실행하여 확인하기에는 프로그램이 크거나 굳이 확인 할 필요없는 부분까지도 확인해야한다
	//또한 자신이 원하지 않는 부분에서 문제점이 발생하면 원하는 부분에서의 확인이 어려워질수도 있다
	//그렇기때문에 단위테스트를 이용하여 작은 부분으로 나누어 테스트를 실행한다
	//작은 단위로 나뉘어 하나씩 확인을 한다면 결국 큰 흐름에도 문제가 없음을 어느정도 증명 할수 있다.
	//단위테스트 프레임워크인 junit을 이용하여 test를 할 수 있다
	//프레임워크를 추가하고 test 어노테이션을 이용하여 테스트 할부분을 체크해준다
	//assertThat 메소드를 이용하여 값들을 비교할 수가 있다.
	//main() 메소드를 하나 생성하여 테스트할 클래스의 위치를 넣어 실행시켜주면 console창에 친절히 성공 또는 에러 
	//표시해준다.	
	@Test 
	public void andAndGet() throws SQLException {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);
		
		User user = new User();
		user.setId("gyumee11");
		user.setName("박성철");
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
