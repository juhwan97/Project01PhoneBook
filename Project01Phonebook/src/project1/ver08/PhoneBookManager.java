package project1.ver08;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class PhoneBookManager extends FileUtil {
	
	//정보 입력
	public void dataInput(int choice) {
		Scanner sc = new Scanner(System.in);
		String name, phoneNumber, major, company;
		int grade;
		System.out.print("이름:");name = sc.nextLine();
		System.out.print("전화번호:");phoneNumber = sc.nextLine();
		
		if(choice==MenuItem.GENERAL) {
			PhoneInfo pi = new PhoneInfo (name, phoneNumber);
			lists.add(pi);
			
		}
		else if(choice==MenuItem.FRIEND) {
			System.out.print("전공:"); major=sc.nextLine();
			System.out.print("학년:"); grade=sc.nextInt();
			PhoneInfo pi = new PhoneInfo(name, phoneNumber, major, grade);
			lists.add(pi);
		}
		else if(choice ==MenuItem.COMPANY) {
			System.out.print("회사명:"); company=sc.nextLine();
			PhoneInfo pi = new PhoneInfo(name, phoneNumber, company);
			lists.add(pi);
		}
		
		System.out.println("==정보가 입력되었습니다.==");
		
	}
	
	//검색 메소드
	public void dataSearch() {
		boolean isFind = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = sc.nextLine();
		
		for(int i=0 ; i<lists.size() ; i++) {
			if(searchName.compareTo(lists.get(i).name)==0) {
				lists.get(i).showPhoneInfo();
				System.out.println("**귀하가 요청하는 정보를 찾았습니다**");
				isFind = true;
			}
		}
		if(isFind==false)
			System.out.println("***찾는 정보가 없습니다***");
	}
	
	//전체정보출력용 메서드
	public void dataAllShow() {
		for(int i=0 ; i<lists.size() ; i++) {
			System.out.println(lists.get(i));
		}
		System.out.println("==전체정보가 출력되었습니다==");
	}
	
	//삭제 메소드
	public void dataDelete() {
	
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 이름을 입력하세요:");
		String deleteName = sc.nextLine();
		
		for(int i=0; i<lists.size(); i++) {
			if(deleteName.compareTo(lists.get(i).name)==0) {
				lists.remove(i);
			}
		}
		System.out.println("==삭제가 완료되었습니다==");
	}
	
	
	//쓰기용 메소드
	public static void saveInfo(String dir, String name, List<PhoneInfo> lists) throws
		IOException {
		OutputStream out = null;
		try {
			File dirent = new File(dir);
			
			if(!dirent.exists()) {
				dirent.mkdir();
			}
			
			File outFile = new File(dir, name);
			
			if(outFile.exists()) {
				outFile.delete();
			}
			out = new BufferedOutputStream(new FileOutputStream(outFile));
			for(int i=0; i<lists.size(); i++) {
				String writeStr = lists.get(i).getName()+ "," + lists.get(i).getPhone()+","+
					lists.get(i).getMajor()+","+lists.get(i).getGrade()+","+lists.get(i).getCompany();
				
				byte[] b = writeStr.getBytes();
				out.write(b);
			}
		} catch(IOException e) {
			System.out.println("입출력 예외발생");
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if(out!= null) out.close();
			} catch(Exception e) {
				
			}
		}
	}
	//읽기용 메소드
	
	public List<PhoneInfo> getInfoList() {
		return this.lists;
	}
	public void setInfoList(List<PhoneInfo> lists) {
		this.lists = lists;
	}
	
}
