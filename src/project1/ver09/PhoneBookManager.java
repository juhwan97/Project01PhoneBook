package project1.ver09;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import project1.ver09.PhoneInfo;
import project1.ver09.connect.IConnectImpl;

public class PhoneBookManager extends IConnectImpl {
	
	public PhoneBookManager() {
		super("kosmo", "1234");
	}
	
	
	public void dataInput() {
		try {
			String query = "INSERT INTO phonebook_tb VALUES "
					+ " (seq_phonebook.nextval, ?, ?, ?)";
				
			psmt = con.prepareStatement(query);
				
			psmt.setString(1, scanValue("이름"));
			psmt.setString(2, scanValue("전화번호"));
			psmt.setString(3, scanValue("생년월일"));
				
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
		
	public void dataSearch() {
		try {
			Statement stmt = con.createStatement();
			String input = scanValue("검색하려는 자료의 이름(name):");
			String query = "SELECT * FROM phonebook_tb "
					+ " WHERE name LIKE '%"+ input + "%'";
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				int idx = rs.getInt(1);
				String name = rs.getString(2);
				String p_number = rs.getString(3);
				java.sql.Date birth = rs.getDate(4);
				
				System.out.printf("%d %s %s %s\n", idx, name, p_number, birth);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close();
		}	
	}
		
	
	public void dataDelete() {
		try {
			String query = "DELETE FROM phonebook_tb WHERE name LIKE "
					+ " '%'||?||'%'";
				
			psmt = con.prepareStatement(query);
				
			psmt.setString(1, scanValue("삭제하려는 자료의 이름(name)"));
				
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 삭제되었습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

}
