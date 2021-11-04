package project1.ver08;

public class AutoSaver extends Thread {

	PhoneBookManager pbm;
	
	public AutoSaver(PhoneBookManager pbm) {
		this.pbm = pbm;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				pbm.saveInfoTxt();
				System.out.println("주소록이 텍스트로 자동저장되었습니다.");
				sleep(5000);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
