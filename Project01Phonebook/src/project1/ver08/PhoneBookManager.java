package project1.ver08;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class PhoneBookManager {
	
	public PhoneInfo[] phoneBook;
	public int numOfPhone;
	
	HashSet<Object> set = new HashSet<Object>();
	
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
		
		if(choice==MenuItem.GENERAL) {
			PhoneInfo pi = new PhoneInfo (name, phoneNumber);
			if(set.add(pi)) {
				phoneBook[numOfPhone++] = pi;
			}
			else {
				System.out.println("이미 저장된 데이터입니다.");
				System.out.println("덮어쓸까요? Y(y)/N(n)");
				char input = sc.next().charAt(0);
				if(input=='Y' || input=='y') {
					for(int i=0 ; i<numOfPhone ; i++) {
						if(name.compareTo(phoneBook[i].name)==0) {
							set.remove(phoneBook[i]);
						}
					}
					phoneBook[numOfPhone++] = pi;
					System.out.println("입력한 정보가 저장되었습니다.");
				}
				else return;
			}
		}
		else if(choice==MenuItem.FRIEND) {
			System.out.print("전공:"); major=sc.nextLine();
			System.out.print("학년:"); grade=sc.nextInt();
			phoneBook[numOfPhone++] = new PhoneInfo(name, phoneNumber, major, grade);
		}
		else if(choice ==MenuItem.COMPANY) {
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
			System.out.println();
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
			System.out.println("==데이터가 삭제되었습니다.");
		}
		if(deleteIndex==-1) {
			System.out.println("==삭제된 데이터가 없습니다==");
		}
		
	}
	
	//파일저장용 메소드
	public void saveInfoTxt() {
		try {
			PrintWriter out = new PrintWriter(new FileWriter("src/project1/ver08/AutoSaveBook.txt"));
			
			for(PhoneInfo p : phoneBook) {
				out.println(p);
			}
			
			out.close();
			System.out.println("주소록이 텍스트로 자동저장되었습니다.");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
