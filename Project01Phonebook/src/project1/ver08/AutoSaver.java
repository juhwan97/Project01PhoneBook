package project1.ver08;

import java.io.IOException;

public class AutoSaver extends Thread {
	

	String filepath = "C:\\02WorkspaceLJH\\Project01Phonebook\\src\\project1\\ver08";
	String filename = "AutoSaveBook.txt";
	PhoneBookManager pm;
	public AutoSaver(PhoneBookManager pm) {
		this.pm = pm;
	}
	
	@Override
	public void run() {
		PhoneBookManager pbm = new PhoneBookManager();
		try {
			FileUtil.saveInfo(filepath, filename, pbm.getInfoList());
			sleep(5000);

		}
		catch(InterruptedException e) {
			System.out.println("자동저장이 interrpted됨.");
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
