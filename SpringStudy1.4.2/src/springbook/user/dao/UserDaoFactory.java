package springbook.user.dao;


//IOC(제어의 역전)
//제어의 역전이란 오브젝트가 자신이 사용할 오브젝트를 스스로 선택하지 않는다.
//UserDao는 Factory로 통해서 만들어지 객체를 받아서 사용하게 된다.
//자신이 어떠한 객체를 사용할지를 정하지 못한다. Factory에서 만들어준 객체만 사용가능하다
//UserDaoTest도 Factory에서 공급해주는 객체를 사용해야한다.
//이런식으로 메인이 되는곳(객체를 사용할곳)에서 객체를 생성하지않고 다른곳(Factory)를 통해 객체를 생성하고 공급받는것을
//제어의 역전이다. 객체를 생성,공급하는 책임을 Factory가 맡게 된다.
//다른 Dao가 추가 될수도 있으니 connetionMaker를 따로 분리 시키면 다른종류의 Dao생성메소드가 있을때 변경이 편해진다.
public class UserDaoFactory {
	public UserDao userDao() {
		UserDao dao = new UserDao(connectionMaker());
		return dao;
	}

	public ConnectionMaker connectionMaker() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		return connectionMaker;
	}
}
