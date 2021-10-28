package project1.ver08;

import java.io.IOException;

public class AutoSaver extends Thread {
	
	PhoneBookManager pm;
	
	public AutoSaver(PhoneBookManager pm) {
		this.pm = pm;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				pm.saveInfoTxt();
				sleep(5000);
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
