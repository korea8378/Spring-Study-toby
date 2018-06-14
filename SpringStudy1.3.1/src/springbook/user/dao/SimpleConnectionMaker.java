package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//상속을 사용하지 않고 커넥션 코드를 따로 클래스로 정의하여 분리
//기존의 상속을 통해 만들면 문제점들이 발생
//다중상속 불가능, 슈퍼클래스 접근, 중복코드 발생
public class SimpleConnectionMaker {
	public Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(
				"jdbc:mysql://localhost/springbook?characterEncoding=UTF-8", "spring", "book");
		return c;
	}
}
