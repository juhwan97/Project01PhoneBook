package project1;

import project1.ver01.PhoneInfo;

public class PhoneBookVer01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PhoneInfo pi = new PhoneInfo("성낙현", "010-7906-3600", "751130");
		PhoneInfo pi2 = new PhoneInfo("류상미", "010-7669-4120");
		
		pi.showPhoneInfo();
		System.out.println();
		pi2.showPhoneInfo();
	}
}
