package Main;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import Presentation.PLogin;
import Presentation.PSugangsincheng;
import valueObject.VUserInfo;

public class Main {
	
	public Main(){
		
	}
	
	private void run() throws FileNotFoundException, UnsupportedEncodingException {
		Scanner keyboard= new Scanner(System.in);
		
		PLogin plogin = new PLogin();
		VUserInfo vuserinfo = plogin.login();
		
		if(vuserinfo != null) {
			System.out.println(vuserinfo);
			PSugangsincheng vsugangsincheng = new PSugangsincheng();
			vsugangsincheng.run(vuserinfo, keyboard);
		}
		keyboard.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		Main main = new Main();
		main.run();
	}

}
