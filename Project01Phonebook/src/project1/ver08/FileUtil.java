package project1.ver08;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {


	public static List<PhoneInfo> readFile(File file) throws IOException {
		FileReader filereader = null;
		List<PhoneInfo> lists = new ArrayList<PhoneInfo>();
		try {
			filereader = new FileReader(file);
			lists = readInfo(filereader);
		} finally {
			if(filereader != null)
				filereader.close();
		}
		
		return lists = lists;
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
	public static List<PhoneInfo> readInfo(Reader input) throws IOException {
		try {
			BufferedReader in = new BufferedReader(input);
			String line;
			
			List<PhoneInfo> lists = new ArrayList<PhoneInfo>();
			
			while((line=in.readLine())!=null) {
				String[] writeStr = line.split(",");
				PhoneInfo phoneInfo = new PhoneInfo();
				phoneInfo.setName(writeStr[0]);
				phoneInfo.setPhone(writeStr[1]);
				phoneInfo.setMajor(writeStr[2]);
				phoneInfo.setGrade(Integer.parseInt(writeStr[3]));
				phoneInfo.setCompany(writeStr[5]);
				
				lists.add(phoneInfo);
			}
			return lists;
		} finally {
			input.close();
		}
	}
	
}
