package project1.ver07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneBookManager {

	private PhoneInfo[] contacts;
	private int numOfContact;
	
	HashSet<PhoneInfo> hashSet = new HashSet<PhoneInfo>();
	
	public PhoneBookManager(int num) {
		contacts = new PhoneInfo[num];
		numOfContact = 0;
	}
	
	public void dataInput(int choice) {
		Scanner sc = new Scanner(System.in);
		String iName,iPhone,iMajor,iCompany;
		int iGrade;
		System.out.println("데이터 입력을 시작합니다...");
		System.out.println("1.일반, 2.동창, 3.회사");
		choice = sc.nextInt();
		sc.nextLine();
		System.out.print("이름: "); iName = sc.nextLine();
		System.out.print("전화번호: "); iPhone = sc.nextLine();
		//System.out.print("생년월일: "); iBirth = sc.nextLine();
		
		if(choice==SubMenuItem.GENERAL) {
			PhoneInfo pi = new PhoneInfo(iName, iPhone);
			if(hashSet.add(pi)) {
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			else {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				char input = sc.next().charAt(0);
				if(input=='Y' || input=='y') {
					Iterator<PhoneInfo> itr = hashSet.iterator();
					while(itr.hasNext()) {
						PhoneInfo pif = itr.next();
						if(iName.equals(pif.name)) {
							hashSet.remove(pif);
							hashSet.add(pi);
							System.out.println("데이터 입력이 완료되었습니다.");
						}
					}
				}
				else if(input=='N' || input=='n') {
					return;
				}
			}
		}
		else if(choice==SubMenuItem.FRIEND) {
			System.out.print("전공: "); iMajor = sc.nextLine();
			System.out.print("학년: "); iGrade = sc.nextInt();
			PhoneInfo pi = new PhoneInfo(iName, iPhone, iMajor, iGrade);
			if(hashSet.add(pi)) {
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			else {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				char input = sc.next().charAt(0);
				if(input=='Y' || input=='y') {
					Iterator<PhoneInfo> itr = hashSet.iterator();
					while(itr.hasNext()) {
						PhoneInfo pif = itr.next();
						if(iName.equals(pif.name)) {
							hashSet.remove(pif);
							hashSet.add(pi);
							System.out.println("데이터 입력이 완료되었습니다.");
						}
					}
				}
				else if(input=='N' || input=='n') {
					return;
				}
			}
		}
		else if(choice==SubMenuItem.COWORKER) {
			System.out.print("회사: "); iCompany = sc.nextLine();
			PhoneInfo pi = new PhoneInfo(iName, iPhone, iCompany);
			if(hashSet.add(pi)) {
				System.out.println("데이터 입력이 완료되었습니다.");
			}
			else {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				char input = sc.next().charAt(0);
				if(input=='Y' || input=='y') {
					Iterator<PhoneInfo> itr = hashSet.iterator();
					while(itr.hasNext()) {
						PhoneInfo pif = itr.next();
						if(iName.equals(pif.name)) {
							hashSet.remove(pif);
							hashSet.add(pi);
							System.out.println("데이터 입력이 완료되었습니다.");
						}
					}
				}
				else if(input=='N' || input=='n') {
					return;
				}
			}
		}
	}
	
	public void dataSearch() {
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("데이터 검색을 시작합니다..");
		System.out.print("이름: "); String searchName = sc.nextLine();
		
		Iterator<PhoneInfo> itr = hashSet.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(searchName.equals(pi.name)) {
				System.out.println(pi);
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
		
		boolean isFind = false;
		
//		for(int i=0; i<numOfContact; i++) {
//			if(deleteName.compareTo(contacts[i].name)==0) {
//				contacts[i] = null;
//				deleteIndex = i;
//				numOfContact--;
//				break;
//			}
//		}
		Iterator<PhoneInfo> itr = hashSet.iterator();
		while(itr.hasNext()) {
			PhoneInfo pi = itr.next();
			if(deleteName.equals(pi.name)) {
				hashSet.remove(pi);
				numOfContact--;
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("==삭제된 데이터가 없습니다.==");
	
	}
	
	public void dataAllShow() {
		
		for(PhoneInfo pi : hashSet) {
			System.out.println(pi.toString());
		}
		System.out.println("전체정보가 출력되었습니다.");
	}
}
