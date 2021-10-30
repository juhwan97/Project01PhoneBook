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
				sleep(5000);
			}
		}
		catch (InterruptedException e) {
			System.out.println("쓰레드 정지됨");
		}
	}
}
