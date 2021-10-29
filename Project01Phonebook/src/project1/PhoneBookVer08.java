package project1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.AutoSaver;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;
import project1.ver08.PhoneInfo;
import project1.ver08.SubMenuItem;

public class PhoneBookVer08 {
	
	public static void printMenu() {
		System.out.println("======================메뉴를 선택하세요====================");
		System.out.println("1.주소록입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료 7.저장 데이터 확인");
		System.out.println("===========================================================");
		System.out.print("메뉴선택:"); 
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int select = 0;
		PhoneBookManager pbm = new PhoneBookManager(100);
		HashSet<Object> set = new HashSet<Object>();
		AutoSaver as = new AutoSaver(pbm);

		while (select != 6) {
			printMenu();
			select = sc.nextInt();
			
			if(select>=1 && select<=7) {
			try {
				if(select==(SubMenuItem.input)) {
					System.out.println("데이터 입력을 시작합니다.");
					System.out.println("1.일반 2.동창 3.회사");
					System.out.print("선택>>");
					int select1_1 = sc.nextInt();
					pbm.dataInput(select1_1);
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
				else if(select==(SubMenuItem.save)) {
					System.out.println("1.자동저장On\n2.자동저장Off\n선택:");
					int saveselect = sc.nextInt();
					if (saveselect==1) {
						as.start();
						System.out.println("자동저장쓰레드 실행됨");
					}
					else if (saveselect==2) {
						as.interrupt();
						System.out.println("자동저장쓰레드 꺼짐");
					}
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
			

	

