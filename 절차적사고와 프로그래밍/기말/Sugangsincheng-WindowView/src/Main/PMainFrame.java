package Main;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import javax.swing.JFrame;

import Presentation.PLogin;
import Presentation.PSugangsincheng;
import valueObject.VUserInfo;

public class PMainFrame extends JFrame{
	
	private Scanner keyboard;
	private PLogin pLogin;
	private PSugangsincheng pSugangsincheng;

	
		public PMainFrame(){
			//initialize attributes
			this.setSize(400,600);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			//add child components
			pLogin = new PLogin();
			pLogin.setVisible(true);
			pSugangsincheng = new PSugangsincheng();
			pSugangsincheng.setVisible(false);
			
			this.add(pLogin);
			this.add(pSugangsincheng);
		}

	
	private void run() throws FileNotFoundException, UnsupportedEncodingException {
		keyboard= new Scanner(System.in);
		
		VUserInfo vUserInfo = pLogin.login(keyboard);
		if(vUserInfo != null) {
			System.out.println(vUserInfo.getName() + "님 안녕하세요."); 
			pLogin.setVisible(false);
			pSugangsincheng.setVisible(true);
			pSugangsincheng.run(vUserInfo, keyboard);
		}
//		keyboard.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		
//		Main main = new Main();
//		main.run();
		
		PMainFrame mainFrame = new PMainFrame();
		mainFrame.setVisible(true);
		mainFrame.run();

	}
}
