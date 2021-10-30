package project1.ver09.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class IConnectImpl implements IConnect {

	public Connection con;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public IConnectImpl(String user, String pass) {
		try {
			Class.forName(ORACLE_DRIVER);
			connect(user, pass);
			System.out.println("드라이버 로딩 완료");
		}
		catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void connect(String user, String pass) {
		try {
			con = DriverManager.getConnection(ORACLE_URL, user, pass);
			System.out.println("데이터베이스 연결 성공");
		}
		catch(SQLException e) {
			System.out.println("데이터베이스 연결 오류");
			e.printStackTrace();
		}
	}
	@Override
	public void close() {
		try {
			if(con!=null) con.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("데이터베이스 반납 완료");
		}
		catch(Exception e) {
			System.out.println("데이터베이스 반납 중 오류발생");
			e.printStackTrace();
		}
	}
	
	@Override
	public String scanValue(String title) {
		Scanner sc = new Scanner(System.in);
		System.out.print(title+"을(를) 입력:");
		String inputStr = sc.nextLine();
		
		return inputStr;
	}
}
