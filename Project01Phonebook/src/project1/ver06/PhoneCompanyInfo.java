package project1.ver06;

public class PhoneCompanyInfo extends PhoneInfo {
	String name;
	String phoneNumber;
	String companyName;
	public PhoneCompanyInfo(String name, String phoneNumber,
			String companyName) {
		super(name, phoneNumber);
		this.companyName = companyName;
	}
	
	
}
