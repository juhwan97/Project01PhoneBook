package project1;

import java.util.Scanner;

import project1.ver09.PhoneBookManager;

public class PhoneBookVer09 {

	public static void menuShow() {
		System.out.println("선택하세요...");
		System.out.println("1.데이터 입력");
		System.out.println("2.데이터 검색");
		System.out.println("3.데이터 삭제");
		System.out.println("4.프로그램 종료");
		System.out.print("선택: ");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		PhoneBookManager pbm = new PhoneBookManager();
		while(true) {
			menuShow();
			
			int input = sc.nextInt();
			if(input==1) pbm.dataInput();
			else if(input==2) pbm.dataSearch();
			else if(input==3) pbm.dataDelete();
			else if(input==4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}
