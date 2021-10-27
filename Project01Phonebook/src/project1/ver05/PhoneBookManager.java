package project1.ver05;

import java.util.Scanner;

import project1.ver05.PhoneInfo;

public class PhoneBookManager {

	public PhoneInfo[] phoneBook;
	public int numOfPhone;
	
	
	//생성자
	public PhoneBookManager(int num) {
		phoneBook = new PhoneInfo[num];
		numOfPhone = 0;
	}

	//입력 메소드
	public void dataInput(int choice) {
		Scanner sc = new Scanner(System.in);
		String name, phoneNumber, major, company;
		int grade;
		System.out.print("이름:");name = sc.nextLine();
		System.out.print("전화번호:");phoneNumber = sc.nextLine();
		//System.out.print("생년월일:"); birthday = sc.nextLine();
		if(choice==1) {
			PhoneInfo pi = new PhoneInfo(name, phoneNumber);
			phoneBook[numOfPhone++] = pi;
		}
		else if(choice==2) {
			System.out.print("전공:"); major=sc.nextLine();
			System.out.print("학년:"); grade=sc.nextInt();
			phoneBook[numOfPhone++] = new PhoneInfo(name, phoneNumber, major, choice);
		}
		else if(choice ==3) {
			System.out.print("회사명:"); company=sc.nextLine();
			phoneBook[numOfPhone++] = new PhoneInfo(name, phoneNumber, company);
		}
		
		System.out.println("==정보가 입력되었습니다.==");
	}
	
	//검색 메소드
	public void dataSearch() {
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = sc.nextLine();
		
		for(int i=0 ; i<numOfPhone ; i++) {
			if(searchName.compareTo(phoneBook[i].name)==0) {
				phoneBook[i].showPhoneInfo();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다**");
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다***");
	}
	
	//전체정보출력용 메서드
	public void dataAllShow() {
		for(int i=0 ; i<numOfPhone ; i++) {
			phoneBook[i].showPhoneInfo();
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	
	//삭제 메소드
	public void dataDelete() {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.nextLine();
		
		int deleteIndex = -1;
		
		for(int i=0; i<numOfPhone; i++) {
			if(deleteName.compareTo(phoneBook[i].name)==0) {
				phoneBook[i] = null;
				deleteIndex = i;
				numOfPhone--;
				break;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		else {
			for(int i=deleteIndex ; i<numOfPhone ; i++) {
				System.out.println("==데이터("+deleteIndex
						+"번)가 삭제되었습니다==");
			}
		}
	}
}