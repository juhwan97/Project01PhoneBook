package project1.ver03;

import java.util.Scanner;

public class PhoneBookManager {

	private PhoneInfo[] contacts;
	private int numOfContact;
	
	public PhoneBookManager(int num) {
		contacts = new PhoneInfo[num];
		numOfContact = 0;
	}
	
	public void dataInput() {
		Scanner sc = new Scanner(System.in);
		String iName,iPhone,iBirth;
		System.out.println("데이터 입력을 시작합니다...");
		System.out.print("이름: "); iName = sc.nextLine();
		System.out.print("전화번호: "); iPhone = sc.nextLine();
		System.out.print("생년월일: "); iBirth = sc.nextLine();
		
		contacts[numOfContact++] = new PhoneInfo(iName, iPhone, iBirth);
		System.out.println("데이터 입력이 완료되었습니다.");
	}
	
	public void dataSearch() {
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름: "); String searchName = sc.nextLine();
		
		for(int i=0; i<numOfContact; i++) {
			if(searchName.compareTo(contacts[i].name)==0) {
				contacts[i].showPhoneInfo();
				System.out.println("데이터 검색이 완료되었습니다.");
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("==찾는 정보가 없습니다.==");
	}
	
	public void dataDelete() {
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 삭제를 시작합니다..");
		System.out.print("이름: "); String deleteName = sc.nextLine();
		
		int deleteIndex = -1;
		
		for(int i=0; i<numOfContact; i++) {
			if(deleteName.compareTo(contacts[i].name)==0) {
				contacts[i] = null;
				deleteIndex = i;
				numOfContact--;
				break;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다.==");
		}
		else {
			for(int i=deleteIndex; i<numOfContact; i++) {
				contacts[i] = contacts[i+1];
			}
			System.out.println("데이터 삭제가 완료되었습니다.");
		}
	}
	
	public void dataAllShow() {
		for(int i=0; i<numOfContact; i++) {
			contacts[i].showPhoneInfo();
		}
		System.out.println("전체정보가 출력되었습니다.");
	}
}
