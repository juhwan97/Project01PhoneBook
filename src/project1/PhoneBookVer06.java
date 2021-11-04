package project1;

import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver06.MenuItem;
import project1.ver06.PhoneBookManager;
import project1.ver06.SubMenuItem;
import project1.ver06.MenuSelectException;

public class PhoneBookVer06 implements MenuItem, SubMenuItem {

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
			int input = 0;
			try {
				input = readMenu();
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
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
	
	public static int readMenu() throws MenuSelectException {
		Scanner sc = new Scanner(System.in);
		int inputMenu=0;
		try {
			inputMenu = sc.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("정수를 입력하세요.");
			e.printStackTrace();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		if(inputMenu<1 || inputMenu>5) {
			MenuSelectException mse = new MenuSelectException();
			throw mse;
		}
		return inputMenu;
	}
}
