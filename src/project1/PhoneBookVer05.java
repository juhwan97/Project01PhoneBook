package project1;

import java.util.Scanner;

import project1.ver05.MenuItem;
import project1.ver05.PhoneBookManager;
import project1.ver05.SubMenuItem;

public class PhoneBookVer05 implements MenuItem, SubMenuItem {

	public static void menuShow() {
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.주소록 출력");
		System.out.println("5.프로그램 종료");
		System.out.print("선택: ");
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
			else if(input==MenuItem.EXIT) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}
}
