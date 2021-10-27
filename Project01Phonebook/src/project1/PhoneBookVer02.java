package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sel = 0;
		while(sel != 2) {
			System.out.println("선택:");
			System.out.println("1.데이터 입력\n2.프로그램 종료");
			sel = sc.nextInt();
			
			if(sel==1) {
				sc.nextLine();
				System.out.print("이름:");
				String name = sc.nextLine();
				System.out.print("전화번호:");
				String p_number = sc.nextLine();
				System.out.print("생년월일:");
				String birth = sc.nextLine();
				
				PhoneInfo pi = new PhoneInfo(name, p_number, birth);
				System.out.println();
				System.out.println("입력된 정보 출력...");
				System.out.println("이름: "+ name);
				System.out.println("전화번호: "+ p_number);
				System.out.println("생년월일: "+ birth);
			}
			else if(sel==2) {
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
		}
	
	}
	

}
