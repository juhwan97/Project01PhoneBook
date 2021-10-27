package project1;

import java.util.Scanner;

import project1.ver03.PhoneBookManager;

public class PhoneBookVer03 {
	
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
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				pbm.dataInput();
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
				return;
			}	
		}
		
	}
}

