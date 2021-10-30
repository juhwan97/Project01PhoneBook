package project1;

import java.io.IOException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.AutoSaver;
import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;
import project1.ver08.SubMenuItem;

public class PhoneBookVer08 {
	
	
	public static void printMenu() {
		System.out.println("======================메뉴를 선택하세요====================");
		System.out.println("1.주소록입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료");
		System.out.println("===========================================================");
		System.out.print("메뉴선택:"); 
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		int select = 0;
		
		PhoneBookManager pbm = new PhoneBookManager(100);
		AutoSaver as = new AutoSaver(pbm);
		
		HashSet<Object> set = new HashSet<Object>();
	
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
						
						System.out.println("==저장옵션선택==");
						System.out.println("저장옵션을 선택하세요.");
						System.out.print("1.자동저장On, 2.자동저장Off\n선택:");
						int select5_1 = sc.nextInt();
						if(select5_1 == 1) {
							if(!as.isAlive()) {
								System.out.println("자동저장을 시작합니다.");
								as.start();
							}
							else if(as.isAlive()) {
								System.out.println("이미 자동저장이 실행중입니다.");
							}
						}
						else if(select5_1 == 2) {
							as.interrupt();
							continue;
						}
					}
					else if(select==(SubMenuItem.exit)) {
						System.out.println("프로그램종료");
						as.interrupt();
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
			

	

