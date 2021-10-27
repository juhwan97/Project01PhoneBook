package project1;

import java.util.Scanner;

import project1.ver04.PhoneBookManager;
import project1.ver05.MenuItem;
import project1.ver05.SubMenuItem;

public class PhoneBookVer04 {
	
	public static void printMenu() {
		System.out.println("메뉴를 선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
	}
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager(100);
		while(true) {
			printMenu();
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				System.out.println("데이터 입력을 시작합니다.");
				System.out.println("1.일반 2.동창 3.회사");
				System.out.print("선택>>");
				int select1_1 = sc.nextInt();
				switch(select1_1) {
				case 1:
					pbm.dataInput(1);
					break;
				case 2:
					pbm.dataInput(2);
					break;
				case 3:
					pbm.dataInput(3);
					break;
				}
				break;
			case 2:
				pbm.dataSearch();
				break;
			case 3:
				pbm.dataDelete();
				break;
			case 4:
				pbm.dataAllShow();
				break;
			case 5:
				System.out.println("프로그램종료");
				System.exit(0);
			}
		}
					
	}
}
