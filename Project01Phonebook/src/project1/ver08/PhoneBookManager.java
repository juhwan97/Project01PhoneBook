package project1.ver08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import project1.ver08.PhoneInfo;

public class PhoneBookManager {
	
	public PhoneInfo[] phoneBook;
	public int numOfPhone;
	PhoneInfo pi;
	
	HashSet<Object> set = new HashSet<Object>();
	
	Scanner sc = new Scanner(System.in);
	
	private final File dataFile = 
		new File("src/project1/ver08/PhoneBook.obj");
	
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
		
		System.out.println("===입력이 완료되었습니다===");
		
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
	public void dataSaveOption(AutoSaver sa) {
		
		System.out.println("저장옵션을 선택하세요.");
		System.out.print("1.자동저장On, 2.자동저장Off\n선택:");
		int menu = sc.nextInt();
		if(menu==1) {
			//텍스트로 저장되는지 테스트
			//saveInfoTxt();
			
			//자동저장 쓰레드 start
			if(!sa.isAlive()) {//쓰레드가 살아있는지 확인
				sa.setDaemon(true);
				sa.start();
				System.out.println("자동저장을 시작합니다.");
			}
			else {
				System.out.println("이미 자동저장이 실행중입니다.");
			}
		}
		else if(menu==2) {
			if(sa.isAlive()) {
				sa.interrupt();
				System.out.println("자동저장을 종료합니다.");
			}
		}
		else {
			System.out.println("메뉴를 잘못입력하셨습니다.");
		}
	}
	public void saveInfoTxt() throws IOException {
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(dataFile));
		out.writeObject(pi);
	}
}
