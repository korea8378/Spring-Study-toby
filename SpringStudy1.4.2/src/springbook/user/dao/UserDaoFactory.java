package springbook.user.dao;


//IOC(������ ����)
//������ �����̶� ������Ʈ�� �ڽ��� ����� ������Ʈ�� ������ �������� �ʴ´�.
//UserDao�� Factory�� ���ؼ� ������� ��ü�� �޾Ƽ� ����ϰ� �ȴ�.
//�ڽ��� ��� ��ü�� ��������� ������ ���Ѵ�. Factory���� ������� ��ü�� ��밡���ϴ�
//UserDaoTest�� Factory���� �������ִ� ��ü�� ����ؾ��Ѵ�.
//�̷������� ������ �Ǵ°�(��ü�� ����Ұ�)���� ��ü�� ���������ʰ� �ٸ���(Factory)�� ���� ��ü�� �����ϰ� ���޹޴°���
//������ �����̴�. ��ü�� ����,�����ϴ� å���� Factory�� �ð� �ȴ�.
//�ٸ� Dao�� �߰� �ɼ��� ������ connetionMaker�� ���� �и� ��Ű�� �ٸ������� Dao�����޼ҵ尡 ������ ������ ��������.
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
