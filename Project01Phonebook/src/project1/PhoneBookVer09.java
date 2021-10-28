package project1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import project1.ver09.PhoneBookManager;

public class PhoneBookVer09 {
	
	public static void printMenu() {
		System.out.println("메뉴를 선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
	}
	
	public static void main(String[] args) {
		
		printMenu();
		PhoneBookManager pbm = new PhoneBookManager();
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if(input==1) {
			try {
				pbm.login();
				pbm.dataInput();
			}
			catch(SQLException e) {
				System.out.println("데이터베이스 연결 실패");
			}
			finally {
				pbm.close();
			}
		}
		else if(input==2) {
			try {
				pbm.login();
				pbm.dataSearch();
			}
			catch(SQLException e) {
				System.out.println("데이터베이스 연결 실패");
			}
			finally {
				pbm.close();
			}
		}
		else if(input==3) {
			try {
				pbm.login();
				pbm.dataDelete();
			}
			catch(SQLException e) {
				System.out.println("데이터베이스 연결 실패");
			}
			finally {
				pbm.close();
			}
		}
	}
}

