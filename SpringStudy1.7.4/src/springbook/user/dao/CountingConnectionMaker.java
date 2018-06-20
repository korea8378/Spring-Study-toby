package springbook.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingConnectionMaker implements ConnectionMaker {
	int counter = 0;
	private ConnectionMaker realConnectionMaker;

	public CountingConnectionMaker(ConnectionMaker realConnectionMaker) {
		this.realConnectionMaker = realConnectionMaker;
	}

	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		//Ŀ�ؼ��� ȣ��ɶ����� ī��Ʈ ����
		this.counter++;
		//������ DB�� �������ִ� Connection��ü�� makeConnection�޼ҵ带 ȣ��
		return realConnectionMaker.makeConnection();
	}
	
	public int getCounter() {
		return this.counter;
	}
}
