import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import Presentaion.PLogin;
import Presentaion.PSugangsincheng;
import value.VUserInfo;

public class Main {
	
	public Main(){
		
	}
	
	private void run() throws FileNotFoundException, UnsupportedEncodingException {
		PLogin plogin = new PLogin();
		VUserInfo vuserinfo = plogin.login();
		if(vuserinfo != null) {
			System.out.println(vuserinfo);
			PSugangsincheng vsugangsincheng = new PSugangsincheng(vuserinfo);
			vsugangsincheng.run();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
		Main main = new Main();
		main.run();
	}

}
