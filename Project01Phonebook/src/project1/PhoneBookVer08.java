package project1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import project1.ver08.MenuSelectException;
import project1.ver08.PhoneBookManager;
import project1.ver08.PhoneInfo;
import project1.ver08.SubMenuItem;

class AutoSaveT extends Thread {
	
	String name, phoneNumber, major, company;
	int grade;
	
	public AutoSaveT() {
		run();
	}
//	public AutoSaveT(String n, String pn, String m, int g, String c) {
//		this.name = n;
//		this.phoneNumber = pn;
//		this.major = m;
//		this.grade = g;
//		this.company = c;
//		run();
//	}
//	public AutoSaveT(Object obj) {
//		run();
//	}
//	PhoneInfo pi = new PhoneInfo(name, phoneNumber, major, grade, company);
//	public AutoSaveT(String threadName) {
//		super(threadName);
//		run();
//	}
//	void threadMethod() throws InterruptedException, IOException {
//		ObjectOutputStream out = new ObjectOutputStream(
//			new FileOutputStream("src/project1/PhoneBook.obj"));
//		out.writeObject(pi);
//		sleep(5000);
//	}	
	PhoneInfo pi = new PhoneInfo(name, phoneNumber, major, grade, company);
//	@Override
//	public void run() {
//		try {
//			threadMethod();
//		}
//		catch(InterruptedException e) {System.out.println("1오류");}
//		catch(IOException e) {System.out.println("2오류");}
//	}
	public void run() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("src/project1/PhoneBook.obj"));
			out.writeObject(pi);
			try {
				sleep(5000);
			}
			catch(InterruptedException e) {
				System.out.println("1오류발생");
				e.printStackTrace();
			}
		}
		catch(IOException e) {
			System.out.println("2오류발생");
			e.printStackTrace();
		}
	}
//		while(true) {
//			try {	
//				ObjectOutputStream out = new ObjectOutputStream(
//						new FileOutputStream("src/project1/PhoneBook.obj"));
//					
//				out.writeObject(new AutoSaveT());
//				sleep(5000);
//			}
//			catch(InterruptedException e) {
//				System.out.println("오류발생");
//				e.printStackTrace();
//			}
//			catch(IOException e) {
//				System.out.println("오류.무언가없음..");
//				e.printStackTrace();
//			}
//		
//	}
}
public class PhoneBookVer08 {

//	String n, pn, m, c;
//	int gg;
//	public PhoneBookVer08 (String n, String pn, String m, int gg, String c){
//		this.n = n;
//		this.pn = pn;
//		this.m = m;
//		int g = gg;
//		this.c = c;
//	}
	
	public static void printMenu() {
		System.out.println("======================메뉴를 선택하세요====================");
		System.out.println("1.주소록입력 2.검색 3.삭제 4.출력 5.저장옵션 6.종료");
		System.out.println("===========================================================");
		System.out.print("메뉴선택:"); 
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int select = 0;
		PhoneBookManager pbm = new PhoneBookManager(100);
		HashSet<Object> set = new HashSet<Object>();
		while (select != 5) {
			printMenu();
			select = sc.nextInt();
			if(select>=1 && select<=5) {
			try {
				if(select==(SubMenuItem.input)) {
					System.out.println("==주소록을 입력함==");
					System.out.println("데이터 입력을 시작합니다.");
					System.out.println("1.일반 2.동창 3.회사");
					System.out.print("선택>>");
					int select1_1 = sc.nextInt();
					pbm.dataInput(select1_1);
				}
				else if(select==(SubMenuItem.search)) {
					pbm.dataSearch();
				}
				else if(select==(SubMenuItem.delete)) {
					pbm.dataDelete();
				}
				else if(select==(SubMenuItem.allShow)) {
					pbm.dataAllShow();
				}
				else if(select==(SubMenuItem.save)) {
					System.out.println("1.자동저장On\n2.자동저장Off\n선택:");
					int saveselect = sc.nextInt();
					if (saveselect==1) {
						AutoSaveT ast = new AutoSaveT();
						ast.setDaemon(true);
						ast.start();
						System.out.println("자동저장쓰레드 실행됨");
				
					}
					else if (saveselect==2) {
						System.out.println("자동저장쓰레드 실행안됨");
						return;
					}
					continue;
				}
				else if(select==(SubMenuItem.exit)) {
					System.out.println("프로그램종료");
					break;
				}
			}			
			catch(InputMismatchException e) {
				sc.nextLine();
				System.out.println("숫자를 입력하세요.");
			}
			catch(NullPointerException e) {
				sc.nextLine();
				System.out.println("검색결과가 없습니다.");
			}		
			}
			else {
				MenuSelectException mse = new MenuSelectException();
				mse.getMessage();
			}
		}
	}

}
