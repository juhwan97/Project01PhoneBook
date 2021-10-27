package project1;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver07.MenuSelectException;
import project1.ver07.MenuItem;
import project1.ver07.PhoneBookManager;
import project1.ver07.SubMenuItem;

public class PhoneBookVer07 {

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
		int select = 0;
		PhoneBookManager pbm = new PhoneBookManager(100);
		HashSet<Object> set = new HashSet<Object>();
		while (select != 5) {
			printMenu();
			select = sc.nextInt();
			
			if(select>=1 && select<=5) {
			try {
				if(select==(SubMenuItem.input)) {
					System.out.println("데이터 입력을 시작합니다.");
					System.out.println("1.일반 2.동창 3.회사");
					System.out.print("선택>>");
					int select1_1 = sc.nextInt();
					switch(select1_1) {
					case MenuItem.GENERAL:
						pbm.dataInput(1);
						break;
					case MenuItem.FRIEND:
						pbm.dataInput(2);
						break;
					case MenuItem.COMPANY:
						pbm.dataInput(3);
						break;
					}	
				}
				else if(select==(SubMenuItem.search)) {
					pbm.dataSearch();
				}
				else if(select==(SubMenuItem.delete)) {
					pbm.dataDelete();
				}
				else if(select==(SubMenuItem.allShow)) {
					pbm.dataAllShow();
				}
				else if(select==(SubMenuItem.exit)) {
					System.out.println("프로그램종료");
					break;
				}
			}			
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("숫자를 입력하세요.");
			}
			catch(NullPointerException e) {
				sc.nextLine();
				System.out.println("검색결과가 없습니다.");
			}		
			}
			else {
				MenuSelectException mse = new MenuSelectException();
				mse.getMessage();
			}
		}
	}

}
