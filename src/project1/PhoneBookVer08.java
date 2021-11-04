package project1;

import java.util.Scanner;

import project1.ver08.AutoSaver;
import project1.ver08.MenuItem;
import project1.ver08.PhoneBookManager;
import project1.ver08.SubMenuItem;

public class PhoneBookVer08 implements MenuItem, SubMenuItem {

	public static void menuShow() {
		System.out.println("====================메뉴를 선택하세요=====================");
		System.out.println("1.주소록입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료");
		System.out.println("==========================================================");
		System.out.print("메뉴선택:"); 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager(100);
		while(true) {
			menuShow();
			
			int input = sc.nextInt();
			if(input==MenuItem.INPUT) pbm.dataInput(input);
			else if(input==MenuItem.SEARCH) pbm.dataSearch();
			else if(input==MenuItem.DELETE) pbm.dataDelete();
			else if(input==MenuItem.SHOW) pbm.dataAllShow();
			else if(input==MenuItem.SAVE) {
				System.out.println("==자동저장옵션==\n1.자동저장On 2.자동저장Off\n선택: ");
				int sel = sc.nextInt();
				AutoSaver as = new AutoSaver(pbm);
				if(sel==1) {
					if(!(as.isAlive())) {
						System.out.println("자동저장을 시작합니다.");
						as.start();
					}
					else if(as.isAlive()) {
						System.out.println("이미 자동저장이 실행중입니다.");
					}
				}
				else if(sel==2) {
					System.out.println("자동저장을 중단합니다.");
					as.interrupt();
					// 자동저장이 중단이 안됨....
				}
				else {
					System.out.println("메뉴를 잘못 선택하였습니다.");
				}
				
			}
			else if(input==MenuItem.EXIT) {
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}
}
