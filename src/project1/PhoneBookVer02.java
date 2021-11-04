package project1;

import java.util.Scanner;

import project1.ver02.PhoneInfo;

public class PhoneBookVer02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int input = 0;
		while(input!=2) {
			System.out.println("선택하세요...");
			System.out.println("1.데이터 입력");
			System.out.println("2.프로그램 종료");
			System.out.print("선택: "); input = sc.nextInt();
			sc.nextLine();
			
			if(input==1) {
				System.out.print("이름: "); String name = sc.nextLine();
				System.out.print("전화번호: "); String phoneNum = sc.nextLine();
				System.out.print("생년월일: "); String birth = sc.nextLine();
				PhoneInfo pi = new PhoneInfo(name, phoneNum, birth);
				System.out.println();
				System.out.println("입력된 정보 출력...");
				pi.showPhoneInfo();
			}
			else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			System.out.println();
		}
	}

}
